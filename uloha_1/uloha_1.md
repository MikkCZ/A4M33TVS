Optimalizační úlohy
===================
Skupina: **10**  
Řešitelé: **Stanke Michal**, **Timr Marek**, **Voříšek Lukáš**

Optimalizace s ortogonálními poli
---------------------------------
#### Úloha 10
Ověřte, zda kompilátor assembleru překládá správně adresní módy parametrů instrukcí. Adresní
módy jsou následující:
* Indirect
* BasePlusIndex
* RegisterRelative

Sestavte generické testy pro instrukce se 3 a 5 parametry.

Vytvořte testovací plán zajišťující otestování všech binárních vztahů optimalizovaný pomocí
ortogonálních polí. Nalezněte a zvolte vhodné ortogonální pole.

### Instrukce se třemi parametry
Pro instrukci se třemi parametry jsme se rozhodli vybrat ortogonální pole L9 ze stránek univerzity v Yorku, konkrétně pak ze stránky [Orthogonal Arrays][yrk].

<h5> Tabulka L9</h5>
<table style="margin:0px auto;width:70%">
	<thead style="">
		<th style="text-align: center">&nbsp;</th>
		<th style="text-align: center">1</th>
		<th style="text-align: center">2</th>
		<th style="text-align: center">3</th>
		<th style="text-align: center">4</th>
	</thead>
	<tr style="">
		<th style="text-align: center">1</th>
		<td style="text-align:center">1</td>
		<td style="text-align:center">1</td>
		<td style="text-align:center">1</td>
		<td style="text-align:center">1</td>
	</td>
	<tr style="">
		<th style="text-align: center">2</th>
		<td style="text-align:center">1</td>
		<td style="text-align:center">2</td>
		<td style="text-align:center">2</td>
		<td style="text-align:center">2</td>
	</td>
	<tr style="">
		<th style="text-align: center">3</th>
		<td style="text-align:center">1</td>
		<td style="text-align:center">3</td>
		<td style="text-align:center">3</td>
		<td style="text-align:center">3</td>
	</td>
	<tr style="">
		<th style="text-align: center">4</th>
		<td style="text-align:center">2</td>
		<td style="text-align:center">1</td>
		<td style="text-align:center">2</td>
		<td style="text-align:center">3</td>
	</td>
	<tr style="">
		<th style="text-align: center">5</th>
		<td style="text-align:center">2</td>
		<td style="text-align:center">2</td>
		<td style="text-align:center">3</td>
		<td style="text-align:center">1</td>
	</td>
	<tr style="">
		<th style="text-align: center">6</th>
		<td style="text-align:center">2</td>
		<td style="text-align:center">3</td>
		<td style="text-align:center">1</td>
		<td style="text-align:center">2</td>
	</td>
	<tr style="">
		<th style="text-align: center">7</th>
		<td style="text-align:center">3</td>
		<td style="text-align:center">1</td>
		<td style="text-align:center">3</td>
		<td style="text-align:center">2</td>
	</td>
	<tr style="">
		<th style="text-align: center">8</th>
		<td style="text-align:center">3</td>
		<td style="text-align:center">2</td>
		<td style="text-align:center">1</td>
		<td style="text-align:center">3</td>
	</td>
	<tr style="">
		<th style="text-align: center">9</th>
		<td style="text-align:center">3</td>
		<td style="text-align:center">3</td>
		<td style="text-align:center">2</td>
		<td style="text-align:center">1</td>
	</td>
</table>

<h5> Slovník parametrů</h5>
<table style="margin:0px auto;width:60%">
	<thead style="">
		<th style="text-align: center">Kód hodnoty</th>
		<th style="text-align: center">Hodnota parametru</th>
	</thead>
	<tr style="">
		<td style="">1</td>
		<td style="">Indirect</td>
	</td>
	<tr style="">
		<td style="">2</td>
		<td style="">BasePlusIndex</td>
	</td>
	<tr style="">
		<td style="">3</td>
		<td style="">RegisterRelative</td>
	</td>
</table>

<h5> Tabulka testovacích případů</h5>
Sloupec 4 z tabulky L9 jsme vynechali
<table style="margin:0px auto;width:60%">
	<thead style="">
		<th style="text-align: center">Test Case</th>
		<th style="text-align: center">Parametr 1</th>
		<th style="text-align: center">Parametr 2</th>
		<th style="text-align: center">Parametr 3</th>
	</thead>
	<tr style="">
		<th style="text-align: center">1</th>
		<td style="">Indirect</td>
		<td style="">Indirect</td>
		<td style="">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">2</th>
		<td style="">Indirect</td>
		<td style="">BasePlusIndex</td>
		<td style="">BasePlusIndex</td>
	</td>
	<tr style="">
		<th style="text-align: center">3</th>
		<td style="">Indirect</td>
		<td style="">RegisterRelative</td>
		<td style="">RegisterRelative</td>
	</td>
	<tr style="">
		<th style="text-align: center">4</th>
		<td style="">BasePlusIndex</td>
		<td style="">Indirect</td>
		<td style="">BasePlusIndex</td>
	</td>
	<tr style="">
		<th style="text-align: center">5</th>
		<td style="">BasePlusIndex</td>
		<td style="">BasePlusIndex</td>
		<td style="">RegisterRelative</td>
	</td>
	<tr style="">
		<th style="text-align: center">6</th>
		<td style="">BasePlusIndex</td>
		<td style="">RegisterRelative</td>
		<td style="">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">7</th>
		<td style="">RegisterRelative</td>
		<td style="">Indirect</td>
		<td style="">RegisterRelative</td>
	</td>
	<tr style="">
		<th style="text-align: center">8</th>
		<td style="">RegisterRelative</td>
		<td style="">BasePlusIndex</td>
		<td style="">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">9</th>
		<td style="">RegisterRelative</td>
		<td style="">RegisterRelative</td>
		<td style="">BasePlusIndex</td>
	</td>
</table>


<h5>Slovní popis testovacího případu 6</h5>

Proveď instrukci s adresním módem BasePlusIndex pro první parametr, RegisterRelative pro druhý a Indirect pro třetí parametr.

<h5> Instrukce s pěti parametry</h5>
Pro instrukci s pěti parametry jsme se rozhodli vybrat ortogonální pole L16b ze stránek univerzity v Yorku, konkrétně pak ze stránky [Orthogonal Arrays][yrk].
<div style="height: 200px"></div>

<h5> Tabulka L16b</h5>
<table style="margin:0px auto;width:70%">
	<thead style="">
		<th style="text-align: center">&nbsp;</th>
		<th style="text-align: center">1</th>
		<th style="text-align: center">2</th>
		<th style="text-align: center">3</th>
		<th style="text-align: center">4</th>
		<th style="text-align: center">5</th>
	</thead>
	<tr style="">
		<th style="text-align: center">1</th>
		<td style="text-align: center">1</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">1</td>
	</td>
	<tr style="">
		<th style="text-align: center">2</th>
		<td style="text-align: center">1</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">2</td>
	</td>
	<tr style="">
		<th style="text-align: center">3</th>
		<td style="text-align: center">1</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">3</td>
	</td>
	<tr style="">
		<th style="text-align: center">4</th>
		<td style="text-align: center">1</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">4</td>
	</td>
	<tr style="">
		<th style="text-align: center">5</th>
		<td style="text-align: center">2</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">4</td>
	</td>
	<tr style="">
		<th style="text-align: center">6</th>
		<td style="text-align: center">2</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">3</td>
	</td>
	<tr style="">
		<th style="text-align: center">7</th>
		<td style="text-align: center">2</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">2</td>
	</td>
	<tr style="">
		<th style="text-align: center">8</th>
		<td style="text-align: center">2</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">1</td>
	</td>
	<tr style="">
		<th style="text-align: center">9</th>
		<td style="text-align: center">3</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">2</td>
	</td>
	<tr style="">
		<th style="text-align: center">10</th>
		<td style="text-align: center">3</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">1</td>
	</td>
	<tr style="">
		<th style="text-align: center">11</th>
		<td style="text-align: center">3</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">4</td>
	</td>
	<tr style="">
		<th style="text-align: center">12</th>
		<td style="text-align: center">3</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">3</td>
	</td>
	<tr style="">
		<th style="text-align: center">13</th>
		<td style="text-align: center">4</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">3</td>
	</td>
	<tr style="">
		<th style="text-align: center">14</th>
		<td style="text-align: center">4</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">4</td>
	</td>
	<tr style="">
		<th style="text-align: center">15</th>
		<td style="text-align: center">4</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">2</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">1</td>
	</td>
	<tr style="">
		<th style="text-align: center">16</th>
		<td style="text-align: center">4</td>
		<td style="text-align: center">4</td>
		<td style="text-align: center">1</td>
		<td style="text-align: center">3</td>
		<td style="text-align: center">2</td>
	</td>
</table>


<h5> Slovník parametrů</h5>
<table style="margin:0px auto;width:60%">
	<thead style="">
		<th style="text-align: center">Kód hodnoty</th>
		<th style="text-align: center">Hodnota parametru</th>
	</thead>
	<tr style="">
		<td style="text-align: left">1</td>
		<td style="text-align: left">Indirect</td>
	</td>
	<tr style="">
		<td style="text-align: left">2</td>
		<td style="text-align: left">BasePlusIndex</td>
	</td>
	<tr style="">
		<td style="text-align: left">3</td>
		<td style="text-align: left">RegisterRelative</td>
	</td>
	<tr style="">
		<td style="text-align: left">4</td>
		<td style="text-align: left">Indirect</td>
	</td>
</table>
<div style="height: 200px"></div>


<h5> Tabulka testovacích případů</h5></h5>
<table style="margin:0px auto;width:70%;font-size:80%">
	<thead style="">
		<th style="text-align: center">Test case</th>
		<th style="text-align: center">Parametr 1</th>
		<th style="text-align: center">Parametr 2</th>
		<th style="text-align: center">Parametr 3</th>
		<th style="text-align: center">Parametr 4</th>
		<th style="text-align: center">Parametr 5</th>
	</thead>
	<tr style="">
		<th style="text-align: center">1</th>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">2</th>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">BasePlusIndex</td>
	</td>
	<tr style="">
		<th style="text-align: center">3</th>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">RegisterRelative</td>
	</td>
	<tr style="">
		<th style="text-align: center">4</th>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">5</th>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">6</th>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">RegisterRelative</td>
	</td>
	<tr style="">
		<th style="text-align: center">7</th>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">BasePlusIndex</td>
	</td>
	<tr style="">
		<th style="text-align: center">8</th>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">9</th>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">BasePlusIndex</td>
	</td>
	<tr style="">
		<th style="text-align: center">10</th>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">11</th>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">12</th>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">RegisterRelative</td>
	</td>
	<tr style="">
		<th style="text-align: center">13</th>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">RegisterRelative</td>
	</td>
	<tr style="">
		<th style="text-align: center">14</th>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">15</th>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">BasePlusIndex</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
	</td>
	<tr style="">
		<th style="text-align: center">16</th>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">Indirect</td>
		<td style="text-align: left">RegisterRelative</td>
		<td style="text-align: left">BasePlusIndex</td>
	</td>
</table>

<h5> Slovní popis testovacího případu 16</h5>
Proveď instrukci s adresním módem Indirect pro první, druhý a třetí parametr, RegisterRelative pro čtvrtý parametr a BasePlusIndex pro pátý parametr.

Optimalizace s latinskými čtverci
---------------------------------
#### Úloha 10
Ověřte, zda lze provést s úspěchem vybrané akce editoru. Předpokládáme sekvenci akcí pevné délky 6. Na jednotlivých pozicích sekvence mohou být následující akce:

   1. New, Open
   2. SelectLine, SelectAll, SelectChar
   3. Bold, Normal, Cursive
   4. Delete, Insert
   5. JumpStart, JumpEnd, PageUp
   6. Save, SaveAs, Cancel

Vytvořte testovací plán zajišťující otestování všech binárních vztahů optimalizovaný pomocí
latinských čtverců. Zvolte a vypočítejte vhodnou sadu latinských čtverců.


[yrk]: http://www.york.ac.uk/depts/maths/tables/orthogonal.htm "Orthogonal Arrays (Taguchi Designs)"
