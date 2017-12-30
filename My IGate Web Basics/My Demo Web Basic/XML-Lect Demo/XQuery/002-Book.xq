xquery version "1.0";
for $x in doc("books.xml")/bookstore/book
where $x/price>30
order by $x/title
return $x/title



(:

//Output of abouve xquery

<title lang="en">Learning XML</title>
<title lang="en">XQuery Kick Start</title>



FLWOR is an acronym for "For, Let, Where, Order by, Return".

The for clause selects all book elements under the bookstore element  into a variable called $x.

The where clause selects only book elements with a price element with a value greater than 30.

The order by clause defines the sort-order. Will be sort by the title element.

The return clause specifies what should be returned. Here it returns the title elements.

The result of the XQuery expression above will be:





:)