# Roman Numerals

## Part 1 : convert an arabic number to a roman one

Given a positive integer number (eg 42) determine
its Roman numeral representation as a String (eg "XLII").

You cannot write numerals like IM for 999.
Wikipedia states "Modern Roman numerals are written by
expressing each digit separately starting with the
leftmost digit and skipping any digit with a value of zero."

Examples:
<table>
<tr><td>1 ->    "I"</td><td>10 ->    "X"</td><td>100 ->    "C"</td><td>1000 ->    "M"
<tr><td>2 ->   "II"</td><td>20 ->   "XX"</td><td>200 ->   "CC"</td><td>2000 ->   "MM"
<tr><td>3 ->  "III"</td><td>30 ->  "XXX"</td><td>300 ->  "CCC"</td><td>3000 ->  "MMM"
<tr><td>4 ->   "IV"</td><td>40 ->   "XL"</td><td>400 ->   "CD"</td><td>4000 -> "MMMM"
<tr><td>5 ->    "V"</td><td>50 ->    "L"</td><td>500 ->    "D"</td></tr>
<tr><td>6 ->   "VI"</td><td>60 ->   "LX"</td><td>600 ->   "DC"</td></tr>
<tr><td>7 ->  "VII"</td><td>70 ->  "LXX"</td><td>700 ->  "DCC"</td></tr>
<tr><td>8 -> "VIII"</td><td>80 -> "LXXX"</td><td>800 -> "DCCC"</td></tr>
<tr><td>9 ->   "IX"</td><td>90 ->   "XC"</td><td>900 ->   "CM"</td></tr>
</table>

1990 -> "MCMXC"  (1000 -> "M"  + 900 -> "CM" + 90 -> "XC")<br/>
2008 -> "MMVIII" (2000 -> "MM" + 8 -> "VIII")<br/>
  99 -> "XCIX"   (90 -> "XC" + 9 -> "IX")<br/>
  47 -> "XLVII"  (40 -> "XL" + 7 -> "VII")<br/>

## Part 2 : convert an roman number to an arabic one

