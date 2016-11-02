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
table {
  font-size: 80%;
}
</style>

# Strukturální testování - datový tok
Skupina: **10**  
Řešitelé: **Stanke Michal**, **Timr Marek**, **Voříšek Lukáš**

## Zadání úlohy
Následující zdrojový Java kód funkce převeďte na graf řídicího toku (převáděno na datový tok). Nalezněte
du-cesty pro vybranou proměnnou ?999.

<pre style="font-size: .8em">
public int fnc() {
	B999();
	int d999 = 360;
	if( B0() ) then {
		B13();
		int c13 = 299;
	}
	if( B1() ) then {
		if( B2() ) then {
			B12();
			int c12 = d999;
			d999 = 206;
		}
		else {
			B11();
			int d11 = 996;
			d999 = 133;
		}
		for(int d4 = 0; B4(d4); d4++ ) {
			B8();
			int c8 = 837;
		}
		B9();
		int b9 = 814;
		d999 = 42;
	}
	if( B3() ) then {
		B10();
		int c10 = d999;
	}
	for(int a5 = 0; B5(a5); a5++ ) {
		B6();
		int c6 = d999;
	}
	B7();
	int a7 = 697;
}
</pre>


<div class="page-break"></div>

## Převod na graf
Úryvek kódu ze zadání převedeme na graf a to tak, že uzly budou reprezenzovat *vrcholy* grafu a řídící funkce (respektive jejich vyhodnocení) bude představovat hrany grafu.

Pro každý vrchol ještě vedeme záznam definovaných proměnných (klíčové slovo def) a proměnných použitých (klíčové slovo use).

<div class="labeled-img">
  <img src="graph.png" style="max-height: 300px;" />
  <span class="label">obrázek 1 - Model datového toku</span>
</div>


<div class="page-break"></div>

## du-cesty pro proměnnou d999
Du-cesta je vzhledem k proměnné *d999* jednoduchou cestou, která je def-čistá z uzlu n<sub>i</sub> do uzlu n<sub>j</sub>

### Cesty du(n<sub>i</sub>, d999)
Jedná se o cesty vzhledem k proměnné *d999*, které začínají v uzlu *n<sub>i</sub>*.

<table>
	<thead>
		<tr>
			<th style="width: 35em;">Označení cesty</th>
			<th colspan="10">Cesta</th>
		</tr>
	</thead>
		<tr>
			<td>du(b999, d999)</td>
			<td>b999</td><td>b1</td><td>b2</td><td>b12a</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b999</td><td>b13</td><td>b1</td><td>b2</td><td>b12a</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b999</td><td>b1</td><td>b3</td><td>b10</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b999</td><td>b13</td><td>b1</td><td>b3</td><td>b10</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b999</td><td>b13</td><td>b1</td><td>b3</td><td>for5</td><td>b5</td><td>b6</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b999</td><td>b1</td><td>b3</td><td>b10</td><td>for5</td><td>b5</td><td>b6</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b999</td><td>b13</td><td>b1</td><td>b3</td><td>b10</td><td>for5</td><td>b5</td><td>b6</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b999</td><td>b1</td><td>b3</td><td>for5</td><td>b5</td><td>b6</td><td>b5</td><td>b6</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b999</td><td>b13</td><td>b1</td><td>b3</td><td>for5</td><td>b5</td><td>b6</td><td>b5</td><td>b6</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b999</td><td>b1</td><td>b3</td><td>b10</td><td>for5</td><td>b5</td><td>b6</td><td>b5</td><td>b6</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b999</td><td>b13</td><td>b1</td><td>b3</td><td>b10</td><td>for5</td><td>b5</td><td>b6</td><td>b5</td><td>b6</td>
		</tr> 
    <!-- next section -->
		<tr>
			<td>du(b11, d999)</td>
      <td colspan="20">prázdná</td>
		</tr>
    <!-- next section -->
		<tr>
			<td>du(b12b, d999)</td>
      <td colspan="20">prázdná</td>
		</tr>
    <!-- next section -->
		<tr>
			<td>du(b9, d999)</td>
      <td>b9</td><td>b3</td><td>b10</td>
      <td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b9</td><td>b3</td><td>b10</td><td>for5</td><td>b5</td><td>b6</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b9</td><td>b3</td><td>b10</td><td>for5</td><td>b5</td><td>b6</td><td>b5</td><td>b6</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b9</td><td>b3</td><td>for5</td><td>b5</td><td>b6</td>
			<td colspan="20"></td>
		</tr>
		<tr>
			<td></td>
      <td>b9</td><td>b3</td><td>for5</td><td>b5</td><td>b6</td><td>b5</td><td>b6</td>
			<td colspan="20"></td>
		</tr>
	</tbody>
</table>


<div class="page-break"></div>

### Cesty du(n<sub>i</sub>, n<sub>j</sub>, d999)
Jedná se o cesty vzhledem k proměnné *d999*, které začínají v uzlu&nbsp;*n<sub>i</sub>*
a končí v uzlu&nbsp;*n<sub>j</sub>.*

<table>
	<thead>
		<tr>
			<th style="width: 10em;">Označení cesty</th>
			<th colspan="20">Cesta</th>
		</tr>
	</thead>
  <tbody>

  </tbody>
</table>
