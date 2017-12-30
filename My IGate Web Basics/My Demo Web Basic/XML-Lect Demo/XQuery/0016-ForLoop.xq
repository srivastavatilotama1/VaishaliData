xquery version "1.0";
for $x in (1 to 5)
return <test>{$x}</test>


(:
<test>1</test>
<test>2</test>
<test>3</test>
<test>4</test>
<test>5</test>


:)