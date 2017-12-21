# Algorithms
CS 590.06 Algoritmic Programming

Several coins are placed in cells of a board with n rows and m columns, no more
than one coin per cell. Each coin can be of an arbitrarily different value, says, $0.5,
$1, $2 or $5.
1. A robot, located in the upper left cell[1, 1] of the board, needs to collect as
many of the coins as possible, but with largest amount of values, and bring
them to the bottom right cell[n, m]. The total number of coins collected can
be maximal but their total values may not be the maximal. The collected
number of coins may not be the maximal number, but their total values can
be maximal.
2. On each step, the robot can move either once cell to the right or one cell
down from its current location.
3. When the robot visits a cell with a coin, it always picks up that coin.
I. Design an efficient algorithm to find the maximum number of coins the
robot can collect and find a path it needs to follow to do this.
Give a brute force (an exhaustive search) algorithm for doing this?
II. Design an efficient algorithm to find the maximum values of coins the
robot can collect and find a path it need to follow to do this.
Give a brute force (an exhaustive search) algorithm for doing this?
III. Use Random Number Generator for generating coins of arbitrary
different values and placing them in many cells of the board n x m. Some
cells do not have a coin. Some cells have a coin of an arbitrarily value
from {$0.5, $1, $2 or $5}.
For each algorithm, write a program (using Java PL only) for generate
data that demonstrates the time and space efficiency for the algorithm.Shortest-Paths Problems.
Given a weighted, connected undirected graph of 100 nodes, with weighted edges.
(Use Random Number Generator) to created weighted adjacency matrix/list for
representing such a weighted undirected graph.
1. Use Floyd’s Algorithms, compute the all-pairs shortest-paths problem.
Write programs using Floy’s Algorithm to compute the all-pairs shortestpath, if the input weighted connected undirected graph of 100 nodes
represented by a weighted adjacency list and a weighted adjacency matrix.
Compare their time efficiency.
2. Consider the single-source shortest-paths problem, use Dijkstra’s algorithm
to compute the all-pairs shortest-paths for the problems as above. Compare
their time efficiency.
3. Consider again the given weighted connected undirected graph of 100 nodes,
apply Prim’s and Kruskal’s algorithms for constructing a minimum spanning
tree. Compare their time efficiency.
Please use Java Programming Languages ONLY to write programs…
