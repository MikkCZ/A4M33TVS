/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dottocvs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author lukas
 */
public class DotParser {

    private File inputFile;
    private boolean inStructs = false;
    ArrayList<String> edgesLines = new ArrayList<>();
    HashMap<String, Node> nodesMap = new HashMap<>();
    ArrayList<Edge> edgesList = new ArrayList<>();
    String startNodeLine;

    public DotParser(File inputFile) {
        this.inputFile = inputFile;
    }
    
    public DataHolder getData() {
        DataHolder dh = new DataHolder();
        dh.edgesList = edgesList;
        dh.nodesMap = nodesMap;
        return dh;
    }

    public void parse() throws IOException {
        processFile();
        processEdges();
        processStartNode();
    }

    private void processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        }
    }
    
    private void processStartNode() {
        System.out.println("Setting BEGIN node");
        System.out.println(startNodeLine);
        String commandPart = startNodeLine.substring(0, startNodeLine.indexOf('[')).trim().replaceAll(" ", "");
        String startNodeId = commandPart.replaceAll("BEGIN->", "");
        nodesMap.get(startNodeId).setType(Node.NodeType.START);
        System.out.println("   BEGIN is now: " + startNodeId);
    }
    
    private void processEdges() {
        for(String edgeLine : edgesLines) {
            processStoredEdge(edgeLine);
        }
    }

    private void processStoredEdge(String line) {
        System.out.println("EDGE " + line);
        String commandPart = line.substring(0, line.indexOf('[')).trim().replaceAll(" ", "");
        String [] commandSplit = commandPart.split("->");
        String input = getAttribute(line, "label").trim();
        System.out.println("   From:  " + commandSplit[0]);
        System.out.println("   To:    " + commandSplit[1]);
        System.out.println("   Input: " + input);
        
        Edge ed = new Edge(nodesMap.get(commandSplit[0]), nodesMap.get(commandSplit[1]), input, input + "/" + nodesMap.get(commandSplit[1]).getName());
        edgesList.add(ed);
        nodesMap.get(commandSplit[0]).addOutput(ed);
        nodesMap.get(commandSplit[1]).addInput(ed);
    }

    private void processLine(String line) {
        String pureLine = line.trim();
        if (inStructs) {
            processDigraphStructsLine(pureLine);
        } else {
            processBaseLine(pureLine);
        }
    }

    private void processDigraphStructsLine(String line) {
        int commandPartPos = line.indexOf('[');
        String commandPart = null;
        if(commandPartPos >= 0) {
            commandPart = line.substring(0, commandPartPos).replaceAll(" ", "");
        }
        if(line.equals("}")) {
            closeDigraphStructs();
        } else if (line.length() == 0) {
            ignoreLine();
        } else if (line.startsWith("rankdir")) {
            ignoreLine();
        } else if (line.startsWith("margin")) {
            ignoreLine();
        } else if (line.startsWith("bgcolor")) {
            ignoreLine();
        } else if (line.startsWith("edge")) {
            ignoreLine();
        } else if (line.startsWith("node")) {
            ignoreLine();
        } else if (line.startsWith("graph")) {
            ignoreLine();
        } else if (line.startsWith("BEGIN")) {
            processBeginNode(line);
        } else if (line.contains("->")) {
            processEdge(line);
        } else {
            processNode(line);
        }
        
    }
    
    private void processEdge(String line) {
        //System.out.println("EDGE " + line);
        edgesLines.add(line);
    }
    
    private void processNode(String line) {
        System.out.println("NODE " + line);
        String nodeId = line.substring(0, line.indexOf('[')).trim();
        String nodeName = getAttribute(line, "label");
        
        System.out.println("   Node ID:   " + nodeId);
        System.out.println("   Node Name: " + nodeName);
        Node n = new Node(nodeId, nodeName);
        nodesMap.put(nodeId, n);
    }
    
    private String getAttribute(String line, String attribue) {
        int dataPartPosStart = line.indexOf('[');
        int dataPartPosEnd = line.indexOf(']');
        if(dataPartPosStart < 0 || dataPartPosEnd < 0) {
            return null;
        }
        String dataPart = line.substring(dataPartPosStart, dataPartPosEnd);
        int attributePos = dataPart.indexOf(attribue);
        int attributeValPosStart = dataPart.indexOf('"', attributePos);
        int attributeValPosEnd = dataPart.indexOf('"', attributeValPosStart + 1);
        String attributeVal = dataPart.substring(attributeValPosStart + 1, attributeValPosEnd);
        return attributeVal;
    }
    
    private void processBeginNode(String line) {
        System.out.println("BEGIN node");
        if(line.contains("->")) {
            startNodeLine = line;
        }
    }

    private void processBaseLine(String line) {
        switch (line) {
            case "digraph structs {":
                openDigraphStructs();
                break;
            default:
                ignoreLine();
        }
    }

    private void openDigraphStructs() {
        System.out.println("Opening digraph stucture");
        inStructs = true;
    }

    private void closeDigraphStructs() {
        System.out.println("Closing digraph stucture");
        inStructs = false;
    }

    private void ignoreLine() {
        //System.out.println("Ignore line");
    }

}
