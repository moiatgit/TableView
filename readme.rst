#########
TableView
#########

This repo is aimed to help my students in learning tabular data processing.

If you find anything in this repo of any use for you, and you know what you're
doing, please take it freely (no attribution required)

Your well-intentioned feedback will be highly appreciated.


Quick start
===========

Currently, this development contains just a boolean table viewer in Java
using Swing.

If your system has JDK 1.8 or hihgher already installed, you can just download
these java files and run the demo code.  ``DemoBooleanTableView`` demos a sort
of "Hello World".

::

    $ git clone https://github.com/moiatgit/TableView.git
    $ cd TableView
    $ javac DemoBooleanTableView.java
    $ java DemoBooleanTableView

Placing the mouse over a tile will show you its coordinates (col x row)

BooleanTableView: Usage examples
================================

``BooleanTableView`` is currently the main class of this project. You can use it
as follows:

* ``BooleanTableView tableView = new BooleanTableView(20, 10);``

  Creates a grid of 20 columns and 10 rows initialized as unset

* ``BooleanTableView tableView = new BooleanTableView(new boolean[][] { { true, false, true}, {false, true, false}});``

 Creates a grid of 3x2 and initializes it

* ``tableView.setValues(new boolean[][] { { true, false, true}, {false, true, false}});``

  Set new values to the table view. Dimensions must match with those at creation time

 Creates a grid of 3x2 and initializes it

* ``tableView.setValue(4, 3, true);``

  Marcs coordinates (4, 3) as set

* ``tableView.setValue(4, 3, false);``

  Marcs coordinates (4, 3) as unset

* ``tableView.clear();``

  Marcs all coordinates as unset

* ``tableView.wait(1000);``

  Stops execution for 1000  milliseconds (1 second)

* ``tableView.close();``

  Close the view nicely to not be opened again in this execution.


