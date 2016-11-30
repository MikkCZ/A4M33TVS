/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dottocvs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author lukas
 */
public class Node {
    enum NodeType {START, END, STANDARD};
    private String name;
    private String id;
    private NodeType type = NodeType.STANDARD;
    private ArrayList<Edge> input = new ArrayList<>();
    private ArrayList<Edge> output = new ArrayList<>();
    private HashMap<String, Edge> inputMap = new HashMap<>();
    private HashMap<String, Edge> outputMap = new HashMap<>();
    
    public Node(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public ArrayList<Edge> getInput() {
        return input;
    }
    
    public Edge getInput(String name) {
        return inputMap.get(name);
    }

    public void addInput(Edge input) {
        this.input.add(input);
        this.outputMap.put(input.getInput(), input);
    }

    public ArrayList<Edge> getOutput() {
        return output;
    }
    
    public Edge getOutput(String name) {
        return outputMap.get(name);
    }
    
    public void addOutput(Edge output) {
        this.output.add(output);
        this.outputMap.put(output.getInput(), output);
    }
    
}
