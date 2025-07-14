# 🚗 Dijkstra's Algorithm - City Map Pathfinding Visualizer

This Java project is an interactive visualizer for Dijkstra’s algorithm, designed to simulate finding the shortest path between cities on a North American map. The application uses a GUI to allow users to select two cities and visually see the optimal route between them based on real-world-like distances.

## 🧠 Problem Description

The problem solved by this project is:

*How do we efficiently travel from one city to another when given a network of cities and distances between them?*

This is a classic shortest path problem, and it's solved here using Dijkstra’s algorithm, a well-known greedy algorithm that ensures the shortest cost path from a source to a destination in a weighted graph.

## 💡 Features

✅ Interactive GUI with a clickable map

🏙️ City-to-city shortest path calculation using Dijkstra's algorithm

🧭 Visual feedback of visited cities and final shortest path

🎨 Custom map background with city dots and labels

## 🛠️ Technologies Used

Java (Swing/AWT) – GUI and graphics rendering

Graph Data Structure – Manages cities and edges with distances

Dijkstra’s Algorithm – Efficient shortest path search

Custom Mouse Events – To select cities directly on the map

## 🗺️ How It Works

1. Cities are represented as nodes with (x, y) coordinates on a map.

2. Edges between cities represent connections with weights (distances).

3. When two cities are selected by clicking, the program:

   - Runs Dijkstra’s algorithm

   - Displays the shortest path in bright red

   - Lists the order of visited cities in the console

## 📂 File Overview

| File                 | Description                                             |
| -------------------- | ------------------------------------------------------- |
| `Main.java`          | Initializes the map and graph with cities and edges     |
| `Graph.java`         | Defines the graph structure, including cities and edges |
| `Algorithms.java`    | Contains the Dijkstra’s algorithm implementation        |
| `MapVisualizer.java` | Handles the GUI rendering and interaction logic         |
| `map.png`            | Background map image (required in `src/`)               |
