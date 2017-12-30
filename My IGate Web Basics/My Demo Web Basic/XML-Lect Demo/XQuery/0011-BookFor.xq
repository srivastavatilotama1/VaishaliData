xquery version "1.0";
for $x at $i in doc("books.xml")/bookstore/book/title
return <book>{$i}. {data($x)}</book>

(:
<book>1. Everyday Italian</book>
<book>2. Harry Potter</book>
<book>3. XQuery Kick Start</book>
<book>4. Learning XML</book>

The for Clause
The for clause binds a variable to each item returned by the in expression. The for clause results in iteration. There can be multiple for clauses in the same FLWOR expression.

To loop a specific number of times in a for clause, you may use the to keyword:

The at keyword can be used to count the iteration:


It is also allowed with more than one in expression in the for clause. Use comma to separate each in expression:

for $x in (10,20), $y in (100,200)
return <test>x={$x} and y={$y}</test>

<test>x=10 and y=100</test>
<test>x=10 and y=200</test>
<test>x=20 and y=100</test>
<test>x=20 and y=200</test>



:)
