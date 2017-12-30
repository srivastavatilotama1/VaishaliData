xquery version "1.0";
(:
The let clause allows variable assignments and it avoids repeating the same expression many times. The let clause does not result in iteration.

//Output
<test>12345</test>

:)

let $x := (1 to 5)
return <test>{$x}</test>
