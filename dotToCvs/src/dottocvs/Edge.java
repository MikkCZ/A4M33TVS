/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dottocvs;

/**
 *
 * @author lukas
 */
public class Edge {
    private Node from;
    private Node to;
    private String input;
    private String output;

    public Edge(Node from, Node to, String input, String output) {
        this.from = from;
        this.to = to;
        this.input = input;
        this.output = output;
    }
    
    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
    
}
