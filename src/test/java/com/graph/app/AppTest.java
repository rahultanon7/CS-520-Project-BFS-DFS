package com.graph.app;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    App app;

    public AppTest() {
        app=new App();
    }

    @Test
    public void dfsTest0() {

        int s=1, t=4, v=5;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=0;i<v;i++)
            graph.add(new ArrayList<>());
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        graph.set(0, a1);
        List<Integer> a2 = new ArrayList<>();
        a2.add(2);
        a2.add(3);
        graph.set(1, a2);
        List<Integer> a3 = new ArrayList<>();
        a3.add(3);
        a3.add(4);
        graph.set(2, a3);
        List<Integer> arr = app.DFS(s, t, graph, v);
        Assert.assertTrue(arr.get(0) == 4);
        Assert.assertTrue(arr.get(1) == 2);
        Assert.assertTrue(arr.get(2) == 1);
        List<Integer> arr_bfs = app.BFS(s, t, graph, v);
        Assert.assertTrue(arr_bfs.get(0) == 4);
        Assert.assertTrue(arr_bfs.get(1) == 2);
        Assert.assertTrue(arr_bfs.get(2) == 1);
    }

    @Test
    public void dfsTest1() {

        int s=0, t=4, v=7;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=0;i<v;i++)
            graph.add(new ArrayList<>());
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(1);
        graph.set(0, a1);
        List<Integer> a2=new ArrayList<>();
        a2.add(2);
        a2.add(3);
        a2.add(6);
        a2.add(4);
        graph.set(1, a2);
        List<Integer> arr = app.DFS(s, t, graph, v);
        Assert.assertTrue(arr.get(0) == 4);
        Assert.assertTrue(arr.get(1) == 1);
        Assert.assertTrue(arr.get(2) == 0);
        List<Integer> arr_bfs = app.BFS(s, t, graph, v);
        Assert.assertTrue(arr_bfs.get(0) == 4);
        Assert.assertTrue(arr_bfs.get(1) == 1);
        Assert.assertTrue(arr_bfs.get(2) == 0);
    }

    @Test
    public void dfsTest2() {

        int s=1, t=5, v=7;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<v;i++)
            graph.add(new ArrayList<>());
        List<Integer> a1=new ArrayList<>();
        a1.add(1);
        graph.set(0, a1);
        List<Integer> a2=new ArrayList<>();
        a2.add(2);
        graph.set(1, a2);
        List<Integer> a3=new ArrayList<>();
        a3.add(5);
        graph.set(2, a3);
        List<Integer> a4=new ArrayList<>();
        a4.add(4);
        graph.set(3, a4);
        List<Integer> a5=new ArrayList<>();
        a5.add(2);
        a5.add(6);
        graph.set(5, a5);
        List<Integer> arr = app.DFS(s, t, graph, v);
        Assert.assertTrue(arr.get(0) == 5);
        Assert.assertTrue(arr.get(1) == 2);
        Assert.assertTrue(arr.get(2) == 1);
        List<Integer> arr_bfs = app.BFS(s, t, graph, v);
        Assert.assertTrue(arr_bfs.get(0) == 5);
        Assert.assertTrue(arr_bfs.get(1) == 2);
        Assert.assertTrue(arr_bfs.get(2) == 1);
    }

    @Test
    public void dfsTest3() {

        int s=0, t=4, v=5;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=0;i<v;i++)
            graph.add(new ArrayList<>());
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(1);
        a1.add(2);
        graph.set(0, a1);
        List<Integer> a2=new ArrayList<>();
        a2.add(3);
        a2.add(4);
        graph.set(1, a2);
        List<Integer> a3=new ArrayList<>();
        a3.add(4);
        graph.set(3, a3);
        List<Integer> a4=new ArrayList<>();
        a4.add(2);
        graph.set(4, a4);
        List<Integer> arr = app.DFS(s, t, graph, v);
        Assert.assertTrue(arr.get(0) == 4);
        Assert.assertTrue(arr.get(1) == 3);
        Assert.assertTrue(arr.get(2) == 1);
        Assert.assertTrue(arr.get(3) == 0);
        List<Integer> arr_bfs = app.BFS(s, t, graph, v);
        Assert.assertTrue(arr_bfs.get(0) == 4);
        Assert.assertTrue(arr_bfs.get(1) == 1);
        Assert.assertTrue(arr_bfs.get(2) == 0);
    }

    @Test
    public void dfsTest4() {

        int s=0, t=5, v=6;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=0;i<v;i++)
            graph.add(new ArrayList<>());
        ArrayList<Integer> a0=new ArrayList<>();
        a0.add(1);
        graph.set(0, a0);
        List<Integer> a1=new ArrayList<>();
        a1.add(2);
        a1.add(3);
        graph.set(1, a1);
        List<Integer> a2=new ArrayList<>();
        a2.add(4);
        a2.add(5);
        graph.set(2, a2);
        List<Integer> a4=new ArrayList<>();
        a4.add(5);
        graph.set(4, a4);
        List<Integer> arr = app.DFS(s, t, graph, v);
        List<Integer> arr_bfs = app.BFS(s, t, graph, v);
        System.out.println(arr_bfs.size());
        if(arr.size() == 4) {
            Assert.assertTrue(arr.get(0) == 5);
            Assert.assertTrue(arr.get(1) == 1);
            Assert.assertTrue(arr.get(2) == 1);
            Assert.assertTrue(arr.get(3) == 0);
        }
        else if(arr.size() == 5) {
            Assert.assertTrue(arr.get(0) == 5);
            Assert.assertTrue(arr.get(1) == 4);
            Assert.assertTrue(arr.get(2) == 2);
            Assert.assertTrue(arr.get(3) == 1);
            Assert.assertTrue(arr.get(4) == 0);
        }
    }

    @Test
    public void dfsTest5() {

        int s=0, t=2, v=3;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=0;i<v;i++)
            graph.add(new ArrayList<>());
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        graph.set(0, a1);
        List<Integer> a2 = new ArrayList<>();
        a2.add(2);
        graph.set(1, a2);
        List<Integer> arr = app.DFS(s, t, graph, v);
        Assert.assertTrue(arr.get(0) == 2);
        Assert.assertTrue(arr.get(1) == 1);
        Assert.assertTrue(arr.get(2) == 0);
        List<Integer> arr_bfs = app.BFS(s, t, graph, v);
        Assert.assertTrue(arr_bfs.get(0) == 2);
        Assert.assertTrue(arr_bfs.get(1) == 1);
        Assert.assertTrue(arr_bfs.get(2) == 0);
    }
}
