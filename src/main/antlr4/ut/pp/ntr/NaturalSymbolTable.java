package main.antlr4.ut.pp.ntr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NaturalSymbolTable implements SymbolTable<ParseTree> {

    private Stack<Map<String, ParseTree>> scopes;
    //for later use Information lost when scope is closed (i.e., stack is popped)
    private ParseTreeProperty<String> nameProperty;


    public NaturalSymbolTable() {
        scopes = new Stack<>();
        nameProperty = new ParseTreeProperty<>();
        openScope(); // Start with the outermost scope
    }

    @Override
    public void openScope() {
        scopes.push(new HashMap<>());
//        int x = scopeStack.size();
//        System.out.println("scope "+ x +" opened");
    }

    @Override
    public void closeScope() {
        if (scopes.size() <= 1) {
            throw new RuntimeException("Cannot close the outermost scope.");
        }
//        int x = scopeStack.size();
//        System.out.println("scope "+ x +" closed");
        scopes.pop();
    }

    @Override
    public boolean put(String id, ParseTree rec) {
        Map<String, ParseTree> currentScope = scopes.peek();
        if (currentScope.containsKey(id)) {
            return false; // Variable already declared in the current scope
        }
        currentScope.put(id, rec);
        nameProperty.put(rec, id); // Store the name attribute for the parse tree node
//        System.out.println("Current scope contains:" + scopeStack);
        return true;
    }

    @Override
    public ParseTree get(String id) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Map<String, ParseTree> scope = scopes.get(i);
            if (scope.containsKey(id)) {
                return scope.get(id);
            }
        }
        return null; // Variable not found in any scope
    }

    public String getName(ParseTree node) {
        return nameProperty.get(node); // Retrieve the name attribute for the parse tree node
    }
}