xquery version "1.0";
<html>
<body>

<h1>Bookstore</h1>

<ul>
{
for $x in doc("books.xml")/bookstore/book
order by $x/title
return <li>{data($x/title)}. Category: {data($x/@category)}</li>
}
</ul>

</body>
</html>

(:

//Output
<html>
	<body>
		<h1>Bookstore</h1>
			<ul>
				<li>Everyday Italian. Category: COOKING</li>
				<li>Harry Potter. Category: CHILDREN</li>
				<li>Learning XML. Category: WEB</li>
				<li>XQuery Kick Start. Category: WEB</li>
			</ul>
	</body>
</html>


//See next BookCat.xq

:)