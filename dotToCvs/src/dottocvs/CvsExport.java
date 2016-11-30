/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dottocvs;

import java.util.ArrayList;

/**
 *
 * @author lukas
 */
public class CvsExport {
    private DataHolder dh;
    private ArrayList<String> inputs;
    private ArrayList<String> outputs;
    private int maxEdgeName = 5;

    public CvsExport(DataHolder dh) {
        this.dh = dh;
    }
    
    public void export() {
        exportHeader();
        exportBody();
    }
    
    private void exportBody() {
        StringBuilder sb = new StringBuilder();
        for(Node n : dh.nodesMap.values()) {
            sb.append(exportNode(n));
        }
        
        System.out.println(sb.toString());
    }
    
    private String exportNode(Node n) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%20s", n.getId()));
        for(String input : inputs) {
            Edge e = n.getOutput(input);
            sb.append(", ");
            if(e != null) {
                sb.append(e.getTo().getId());
            }
        }
        sb.append(",   ");
        for(String input : inputs) {
            Edge e = n.getOutput(input);
            sb.append(", ");
            if(e != null) {
                sb.append(e.getTo().getId());
            }
        }
        sb.append("\n");
        return sb.toString();
    }
    
    private void exportHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%20s, %s\n", "entry state", entryNode().getId()));
        sb.append(String.format("%20s, %s\n", "exit state", entryNode().getId()));
        sb.append(String.format("%20s, %s\n\n", "default output", "noop"));
        sb.append(String.format("%20s, %s\n", "", "next state, ,,, output"));
        sb.append(String.format("%20s", "current state"));

        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
        for(Edge e : dh.edgesList) {
            if(!inputs.contains(e.getInput())) {
                inputs.add(e.getInput());
                if(e.getInput().length() > maxEdgeName) {
                    maxEdgeName = e.getInput().length();
                }
            }
            if(!outputs.contains(e.getOutput())) {
                outputs.add(e.getOutput());
                if(e.getOutput().length() > maxEdgeName) {
                    maxEdgeName = e.getOutput().length();
                }
            }
        }
        
        for(String e : inputs) {
            sb.append(", ");
            sb.append(e);
        }
        sb.append(",   ");
        for(String e : outputs) {
            sb.append(", ");
            sb.append(e);
        }
        System.out.println(sb.toString());
    }
    
    private Node entryNode() {
        for(Node n : dh.nodesMap.values()) {
            if(n.getType() == Node.NodeType.START) {
                return n;
            }
        }
        return null;
    }
    
}
