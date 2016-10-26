<style>
h6 {
		color: #777777;
}
.labeled-img {
  text-align: center;
  padding: 20px;

}
.labeled-img .label {
  font-size: 100%;
  font-style: italic;
}
.labeled-img img {
  max-width: 50%;
  display: block;
  margin: 0px auto;
  margin-bottom: 1em;
}
.centered-box {
  margin: 0px auto;
}
</style>

<h1>Strukturální testování - řídicí tok</h1>
Skupina: <strong>10</strong><br>
Řešitelé: <strong>Stanke Michal</strong>, <strong>Timr Marek</strong>, <strong>Voříšek Lukáš</strong>

<h2>Zadání úlohy</h2>
<p>Následující zdrojový Java kód funkce převeďte na graf řídicího toku. Metodou
hlavních cest sestrojte sadu testovacích cest, které plně pokryjí daný kód.</p>

<pre style="font-size: .8em">
public int fnc() {
  B999();
  while( B0() ) {
    B7();
  }
  if( B1() ) then {
    B2();
  }
  else {
    B6();
  }
  while( B3() ) {
    B4();
  }
  B5();
}
</pre>

<div class="labeled-img">
  <img src="graph.png" style="max-height: 300px;" />
  <span class="label">obrázek 1 - Model řídícího toku</span>
</div>

<div class="page-break"></div>

<h2>Hledání hlavních cest</h2>
<p>
	<ol>
		<li>Nalezni cesty délky 0 (uzly).</li>
		<li>Kombinuj cesty délky 0 do cest délky 1 (hrany).</li>
		<li>Kombinuj cesty délky 1 do cest délky 2.</li>
		<li>atd.</li>
	</ol>
	Značení:
	<ul>
		<li>! ... cesta nemůže být prodloužena</li>
		<li>* ... cesta tvoří smyčku</li>
	</ul>
</p>


<div style="float: left; width: 33%; vertical-align: top;">
	<h6>Cesty délky 1</h6>
	<ul>  
		<li>999</li>
		<li>0</li>
		<li>1</li>
		<li>2</li>
		<li>3</li>
		<li>4</li>
		<li>5!</li>
		<li>6</li>
		<li>7</li>
	<ul>
</div>

<div style="float: left; width: 33%; vertical-align: top;">
	<h6>Cesty délky 2</h6>
	<ul>
		<li>999&rarr;0</li>
		<li>0&rarr;1</li>
		<li>0&rarr;7</li>
		<li>1&rarr;2</li>
		<li>1&rarr;6</li>
		<li>2&rarr;3</li>
		<li>3&rarr;4</li>
		<li>3&rarr;5!</li>
		<li>4&rarr;3</li>
		<li>6&rarr;3</li>
		<li>7&rarr;0</li>
	</ul>
</div>

<div style="float: left; width: 33%; vertical-align: top;">
	<h6>Cesty délky 3</h6>
	<ul>
		<li>999&rarr;0&rarr;1</li>
		<li>999&rarr;0&rarr;7!</li>
		<li>0&rarr;1&rarr;2</li>
		<li>0&rarr;1&rarr;6</li>
		<li>0&rarr;7&rarr;0*</li>
		<li>1&rarr;2&rarr;3</li>
		<li>1&rarr;6&rarr;3</li>
		<li>2&rarr;3&rarr;4!</li>
		<li>2&rarr;3&rarr;5!</li>
		<li>3&rarr;4&rarr;3*</li>
		<li>4&rarr;3&rarr;4*</li>
		<li>4&rarr;3&rarr;5!</li>
		<li>6&rarr;3&rarr;4!</li>
		<li>6&rarr;3&rarr;5!</li>
		<li>7&rarr;0&rarr;1</li>
		<li>7&rarr;0&rarr;7*</li>
	</ul>
</div>

<div style="float: left; width: 33%; vertical-align: top;">
	<h6>Cesty délky 4</h6>
	<ul>
		<li>999&rarr;0&rarr;1&rarr;2</li>
		<li>999&rarr;0&rarr;1&rarr;6</li>
		<li>0&rarr;1&rarr;2&rarr;3</li>
		<li>0&rarr;1&rarr;6&rarr;3</li>
		<li>1&rarr;2&rarr;3&rarr;4!</li>
		<li>1&rarr;2&rarr;3&rarr;5!</li>
		<li>1&rarr;6&rarr;3&rarr;4!</li>
		<li>1&rarr;6&rarr;3&rarr;5!</li>
		<li>7&rarr;0&rarr;1&rarr;2</li>
		<li>7&rarr;0&rarr;1&rarr;6</li>
	</ul>
</div>

<div style="float: left; width: 33%; vertical-align: top;">
	<h6>Cesty délky 5</h6>
	<ul>
		<li>999&rarr;0&rarr;1&rarr;2&rarr;3</li>
		<li>999&rarr;0&rarr;1&rarr;6&rarr;3</li>
		<li>0&rarr;1&rarr;2&rarr;3&rarr;4!</li>
		<li>0&rarr;1&rarr;2&rarr;3&rarr;5!</li>
		<li>0&rarr;1&rarr;6&rarr;3&rarr;4!</li>
		<li>0&rarr;1&rarr;6&rarr;3&rarr;5!</li>
		<li>7&rarr;0&rarr;1&rarr;2&rarr;5</li>
		<li>7&rarr;0&rarr;1&rarr;6&rarr;3</li>
	</ul>
</div>

<div style="float: left; width: 33%; vertical-align: top;">
	<h6>Cesty délky 6</h6>
	<ul>
		<li>999&rarr;0&rarr;1&rarr;2&rarr;3&rarr;4!</li>
		<li>999&rarr;0&rarr;1&rarr;2&rarr;3&rarr;5!</li>
		<li>999&rarr;0&rarr;1&rarr;6&rarr;3&rarr;4!</li>
		<li>999&rarr;0&rarr;1&rarr;6&rarr;3&rarr;5!</li>
		<li>7&rarr;0&rarr;1&rarr;2&rarr;5&rarr;4!</li>
		<li>7&rarr;0&rarr;1&rarr;2&rarr;5&rarr;5!</li>
		<li>7&rarr;0&rarr;1&rarr;6&rarr;3&rarr;4!</li>
		<li>7&rarr;0&rarr;1&rarr;6&rarr;3&rarr;5!</li>
	</ul>
</div>

<div style="clear: both;"></div>

<div class="page-break"></div>

<h2>Konečné cesty</h2>
Seznam níže obshuje všechny cesty, které jsou konečné, nebo vedou na cyklus.
<ol>
	<li>B5!</li>
	<li>B3&rarr;B5!</li>
	<li>B999&rarr;B0&rarr;B7!</li>
	<li>B0&rarr;B7&rarr;B0*</li>
	<li>B2&rarr;B3&rarr;B4!</li>
	<li>B2&rarr;B3&rarr;B5!</li>
	<li>B3&rarr;B4&rarr;B3*</li>
	<li>B4&rarr;B3&rarr;B4*</li>
	<li>B4&rarr;B3&rarr;B5!</li>
	<li>B6&rarr;B3&rarr;B4!</li>
	<li>B6&rarr;B3&rarr;B5!</li>
	<li>B1&rarr;B2&rarr;B3&rarr;B4!</li>
	<li>B1&rarr;B2&rarr;B3&rarr;B5!</li>
	<li>B1&rarr;B6&rarr;B3&rarr;B4!</li>
	<li>B1&rarr;B6&rarr;B3&rarr;B5!</li>
	<li>B0&rarr;B1&rarr;B2&rarr;B3&rarr;B4!</li>
	<li>B0&rarr;B1&rarr;B2&rarr;B3&rarr;B5!</li>
	<li>B0&rarr;B1&rarr;B6&rarr;B3&rarr;B4!</li>
	<li>B0&rarr;B1&rarr;B6&rarr;B3&rarr;B5!</li>
	<li>B999&rarr;B0&rarr;B1&rarr;B2&rarr;B3&rarr;B4!</li>
	<li>B999&rarr;B0&rarr;B1&rarr;B2&rarr;B3&rarr;B5!</li>
	<li>B999&rarr;B0&rarr;B1&rarr;B6&rarr;B3&rarr;B4!</li>
	<li>B999&rarr;B0&rarr;B1&rarr;B6&rarr;B3&rarr;B5!</li>
	<li>B7&rarr;B0&rarr;B1&rarr;B2&rarr;B5&rarr;B4!</li>
	<li>B7&rarr;B0&rarr;B1&rarr;B2&rarr;B5&rarr;B5!</li>
	<li>B7&rarr;B0&rarr;B1&rarr;B6&rarr;B3&rarr;B4!</li>
	<li>B7&rarr;B0&rarr;B1&rarr;B6&rarr;B3&rarr;B5!</li>
</ol>

<div class="page-break"></div>

<h2>Hlavní cesty</h2>
<p>
	Z předchozího seznamu konečných cest jsme vynechali podcesty jiných
	jednoduchých cest a tak jsme získali seznam hlavních cest, který je
	vypsán v následující tabulce.
</p>
<table style="margin:0px auto">
	<thead style="">
		<th style="text-align: right">Id cesty</th>
		<th style="text-align: left">Cesty:</th>
	</thead>
	<tr style="">
		<th style="text-align: right">1</th>
		<td style="text-align: left;">999&rarr;0&rarr;7!</td>
	</td>
	<tr style="">
		<th style="text-align: right">2</th>
		<td style="text-align: left;">0&rarr;7&rarr;0*</td>
	</td>
	<tr style="">
		<th style="text-align: right">3</th>
		<td style="text-align: left;">3&rarr;4&rarr;3*</td>
	</td>
	<tr style="">
		<th style="text-align: right">4</th>
		<td style="text-align: left;">4&rarr;3&rarr;4*</td>
	</td>
	<tr style="">
		<th style="text-align: right">5</th>
		<td style="text-align: left;">4&rarr;3&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">6</th>
		<td style="text-align: left;">999&rarr;0&rarr;1&rarr;2&rarr;3&rarr;4!</td>
	</td>
	<tr style="">
		<th style="text-align: right">7</th>
		<td style="text-align: left;">999&rarr;0&rarr;1&rarr;2&rarr;3&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">8</th>
		<td style="text-align: left;">999&rarr;0&rarr;1&rarr;6&rarr;3&rarr;4!</td>
	</td>
	<tr style="">
		<th style="text-align: right">9</th>
		<td style="text-align: left;">999&rarr;0&rarr;1&rarr;6&rarr;3&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">10</th>
		<td style="text-align: left;">7&rarr;0&rarr;1&rarr;2&rarr;5&rarr;4!</td>
	</td>
	<tr style="">
		<th style="text-align: right">11</th>
		<td style="text-align: left;">7&rarr;0&rarr;1&rarr;2&rarr;5&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">12</th>
		<td style="text-align: left;">7&rarr;0&rarr;1&rarr;6&rarr;3&rarr;4!</td>
	</td>
	<tr style="">
		<th style="text-align: right">13</th>
		<td style="text-align: left;">7&rarr;0&rarr;1&rarr;6&rarr;3&rarr;5!</td>
	</td>
</table>

<div class="page-break"></div>

<h2>Testovací cesty</h2>
<p>
	Nyní z předchozích hlavních cest zkonstruujeme cesty testovací, které mají
	tu vlastnost, že začínají v počátečním uzlu (999) a končí v koncovém (5).
	Tyto cesty nám zaručí spolehlivé pokrytí možných variant a určují tak,
	které průběhy musí tester vyzkoušet, aby bylo zarućeno, že se systém
	chová správně.
</p>
<table style="margin:0px auto">
	<thead style="">
		<th style="text-align: right">Označení testovací cesty (z jakých hlavních cest byla složena):</th>
		<th style="text-align: left">Cesta:</th>
	</thead>
	<tr style="">
		<th style="text-align: right">7</th>
		<td style="text-align: left;">999&rarr;0&rarr;1&rarr;2&rarr;3&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">9</th>
		<td style="text-align: left;">999&rarr;0&rarr;1&rarr;6&rarr;3&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">6+3+5</th>
		<td style="text-align: left;">999&rarr;0&rarr;1&rarr;2&rarr;3&rarr;4&rarr;3&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">8+5</th>
		<td style="text-align: left;">999&rarr;0&rarr;1&rarr;6&rarr;3&rarr;4&rarr;3&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">1+2+11</th>
		<td style="text-align: left;">999&rarr;0&rarr;7&rarr;0&rarr;1&rarr;2&rarr;5&rarr;5!</td>
	</td>
  <tr style="">
		<th style="text-align: right">1+2+11</th>
		<td style="text-align: left;">999&rarr;0&rarr;7&rarr;0&rarr;1&rarr;2&rarr;5&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">1+13</th>
		<td style="text-align: left;">999&rarr;0&rarr;7&rarr;0&rarr;1&rarr;6&rarr;3&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">1+10+5</th>
		<td style="text-align: left;">999&rarr;0&rarr;7&rarr;0&rarr;1&rarr;2&rarr;5&rarr;4&rarr;3&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">1+12+5</th>
		<td style="text-align: left;">999&rarr;0&rarr;7&rarr;0&rarr;1&rarr;6&rarr;3&rarr;4&rarr;3&rarr;5!</td>
	</td>
	<tr style="">
		<th style="text-align: right">6+4+5</th>
		<td style="text-align: left;">999&rarr;0&rarr;1&rarr;2&rarr;3&rarr;4&rarr;3&rarr;4&rarr;3&rarr;5!</td>
	</td>
</table>

Pro ilustraci si z tabulky výše vybereme například testovací cestu označenou
jako **9**. To pro testera znamená, že obrazovky, funkcionalitu či flow musí
zkontrolovat ve zmíněných krocích. V našem případě tedy musí být zkontrolován
průběh funkce `fnc` (vrací navzdory zadání void) tak, že bude zavolána sekvence
funkcí `B999`, `B0`, `B1`, `B6`, `B3`, `B5`. Tedy například víme, že funkce `B0`
vrátí nepravdu (v tomto konkrétním případě), neboť neproběhne zavolání funkce
`B7`.
