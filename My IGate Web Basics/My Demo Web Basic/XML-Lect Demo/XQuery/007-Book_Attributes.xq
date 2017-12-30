xquery version "1.0";
for $x in doc("books.xml")/bookstore/book/title
order by $x
return $x

(:

//Output
<title lang="en">Everyday Italian</title>
<title lang="en">Harry Potter</title>
<title lang="en">Learning XML</title>
<title lang="en">XQuery Kick Start</title>


:)
