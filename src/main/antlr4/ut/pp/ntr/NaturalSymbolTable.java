package main.antlr4.ut.pp.ntr;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NaturalSymbolTable implements SymbolTable<ParseTree> {

    private Stack<Map<String, ParseTree>> scopes;

    public NaturalSymbolTable() {
        scopes = new Stack<>();
        openScope(); // Initialize with the outer scope
    }

    @Override
    public void openScope() {
        scopes.push(new HashMap<>());
    }

    @Override
    public void closeScope() {
        if (scopes.size() <= 1) {
            throw new RuntimeException("Cannot close the outer scope.");
        }
        int x = scopes.size();
        System.out.println("scope " + x + " closed");
        scopes.pop();
    }

    @Override
    public boolean put(String id, ParseTree rec) {
        Map<String, ParseTree> currentScope = scopes.peek();
        if (currentScope.containsKey(id)) {
            return false; // Identifier already declared in this scope
        }
        int x = scopes.size();
        currentScope.put(id, rec);
        System.out.println("scope " + x + " opened");
        System.out.println(scopes);
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
        return null; // Identifier not found in any scope
    }
}