<style>
h6 {
		color: #777777;
}
</style>

Optimalizační úlohy
===================
Skupina: **10**  
Řešitelé: **Stanke Michal**, **Timr Marek**, **Voříšek Lukáš**

Optimalizace s ortogonálními poli
---------------------------------
### Úloha 10
Ověřte, zda kompilátor assembleru překládá správně adresní módy parametrů instrukcí. Adresní
módy jsou následující:
* Indirect
* BasePlusIndex
* RegisterRelative

Sestavte generické testy pro instrukce se 3 a 5 parametry.

Vytvořte testovací plán zajišťující otestování všech binárních vztahů optimalizovaný pomocí
ortogonálních polí. Nalezněte a zvolte vhodné ortogonální pole.

#### Identifikace faktorů a úrovní
V této úloze jsou jednotlivými faktury parametry instrukce. Úrovněmi jsou pak adresní módy Indirect, BasePlusIndex a RegisterRelative.

#### Instrukce se třemi parametry
Pro instrukci se třemi parametry jsme se rozhodli vybrat ortogonální pole L9 ze stránek univerzity v Yorku, konkrétně pak ze stránky [Orthogonal Arrays][yrk]. L9 je pole pro až čtyři parametry se třemi úrovněmi.

##### Ortogonální pole L9
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

##### Slovník parametrů
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

##### Tabulka testovacích případů
Sloupec 4 z ortogonálního pole L9 jsme vynechali
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

##### Slovní popis testovacího případu 6
Proveď instrukci s adresním módem BasePlusIndex pro první parametr, RegisterRelative pro druhý a Indirect pro třetí parametr.

<div class="page-break" />

#### Instrukce s pěti parametry
Pro instrukci s pěti parametry jsme se rozhodli vybrat ortogonální pole L16b ze stránek univerzity v Yorku, konkrétně pak ze stránky [Orthogonal Arrays][yrk]. L16b je pole pro až pět parametrů se čtyřmi úrovněmi.


##### Ortogonální pole L16b
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

<div class="page-break" />

<h5>Tabulka testovacích případů</h5>
<table style="margin:0px auto;width:70%;font-size:80%;margin-bottom:100px;">
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

##### Slovní popis testovacího případu 16
Proveď instrukci s adresním módem Indirect pro první, druhý a třetí parametr, RegisterRelative pro čtvrtý parametr a BasePlusIndex pro pátý parametr.


<div class="page-break" />

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

##### Identifikace parametrů a významných hodnot
parametry = pozice v sekvenci akcí
významné hodnoty = možné akce na jednotlivých pozicích (podle zadání)

##### Volba čtverce
V úloze jsme potřebovali do čtverce zakódovat až tři významné hodnoty a zároveň šest parametrů. Podle "pravidla" n+1 jsme tak zvolili n=5 a použili čtyři čtverce 5x5 z [přednáškových slajdů][slides].

##### Latinské čtverce
<h6>C1</h6>
<table style="margin:0px auto;width:60%">
	<tr style="">
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
	</td>
	<tr style="">
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
	</td>
	<tr style="">
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
	</td>
	<tr style="">
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
	</td>
	<tr style="">
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
	</td>
</table>


<h6>C2</h6>
<table style="margin:0px auto;width:60%">
	<tr style="">
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
	</td>
	<tr style="">
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
	</td>
	<tr style="">
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
	</td>
	<tr style="">
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
	</td>
	<tr style="">
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
	</td>
</table>

<div class="page-break" />

<h6>C3</h6>
<table style="margin:0px auto;width:60%">
	<tr style="">
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
	</td>
	<tr style="">
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
	</td>
	<tr style="">
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
	</td>
	<tr style="">
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
	</td>
	<tr style="">
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
	</td>
</table>
<h6>C4</h6>
<table style="margin:0px auto;width:60%">
	<tr style="">
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
	</td>
	<tr style="">
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
	</td>
	<tr style="">
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
	</td>
	<tr style="">
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
		<td style="text-align: center;">1</td>
	</td>
	<tr style="">
		<td style="text-align: center;">1</td>
		<td style="text-align: center;">2</td>
		<td style="text-align: center;">3</td>
		<td style="text-align: center;">4</td>
		<td style="text-align: center;">0</td>
	</td>
</table>
<div style="height: 1em"></div>

<h5> Tabulka pro interpretaci číselných hodnot z latinských čtverců</h5>
* i, j = iterační proménné a tedy indexy pozic ve čtvercích odpovídají první a druhé akci
* C1 - C4 = pole jednotlivých čtverců odpovídají třetí až šesté akci

<table style="margin:0px auto;font-size:80%">
	<thead style="">
		<th style="text-align: center">hodnoty</th>
		<th style="text-align: center">i</th>
		<th style="text-align: center">j</th>
		<th style="text-align: center">C1</th>
		<th style="text-align: center">C2</th>
		<th style="text-align: center">C3</th>
		<th style="text-align: center">C4</th>
	</thead>
	<tr style="">
		<th style="text-align: center">0</th>
		<td style="text-align: left;">New</td>
		<td style="text-align: left;">SelectLine</td>
		<td style="text-align: left;">Bold</td>
		<td style="text-align: left;">Delete</td>
		<td style="text-align: left;">JumpStart</td>
		<td style="text-align: left;">Save</td>
	</td>
	<tr style="">
		<th style="text-align: center">1</th>
		<td style="text-align: left;">Open</td>
		<td style="text-align: left;">SelectAll</td>
		<td style="text-align: left;">Normal</td>
		<td style="text-align: left;">Insert</td>
		<td style="text-align: left;">JumpEnd</td>
		<td style="text-align: left;">SaveAs</td>
	</td>
	<tr style="">
		<th style="text-align: center">2</th>
		<td style="text-align: left;">New</td>
		<td style="text-align: left;">SelectChar</td>
		<td style="text-align: left;">Cursive</td>
		<td style="text-align: left;">Delete</td>
		<td style="text-align: left;">PageUp</td>
		<td style="text-align: left;">Cancel</td>
	</td>
	<tr style="">
		<th style="text-align: center">3</th>
		<td style="text-align: left;">Open</td>
		<td style="text-align: left;">SelectLine</td>
		<td style="text-align: left;">Bold</td>
		<td style="text-align: left;">Insert</td>
		<td style="text-align: left;">JumpStart</td>
		<td style="text-align: left;">Save</td>
	</td>
	<tr style="">
		<th style="text-align: center">4</th>
		<td style="text-align: left;">New</td>
		<td style="text-align: left;">SelectChar</td>
		<td style="text-align: left;">Normal</td>
		<td style="text-align: left;">Delete</td>
		<td style="text-align: left;">JumpEnd</td>
		<td style="text-align: left;">SaveAs</td>
	</td>
</table>
<div style="height: 30px"></div>

##### Latinské čtverce s významnými hodnotami
<h6>C1 (třetí akce)</h6>
<table style="margin:0px auto;width:60%">
	<tr style="">
		<td style="text-align: center;">Bold</td>
		<td style="text-align: center;">Normal</td>
		<td style="text-align: center;">Cursive</td>
		<td style="text-align: center;">Bold</td>
		<td style="text-align: center;">Normal</td>
	</td>
	<tr style="">
		<td style="text-align: center;">Normal</td>
		<td style="text-align: center;">Cursive</td>
		<td style="text-align: center;">Bold</td>
		<td style="text-align: center;">Normal</td>
		<td style="text-align: center;">Bold</td>
	</td>
	<tr style="">
		<td style="text-align: center;">Cursive</td>
		<td style="text-align: center;">Bold</td>
		<td style="text-align: center;">Normal</td>
		<td style="text-align: center;">Bold</td>
		<td style="text-align: center;">Normal</td>
	</td>
	<tr style="">
		<td style="text-align: center;">Bold</td>
		<td style="text-align: center;">Normal</td>
		<td style="text-align: center;">Bold</td>
		<td style="text-align: center;">Normal</td>
		<td style="text-align: center;">Cursive</td>
	</td>
	<tr style="">
		<td style="text-align: center;">Normal</td>
		<td style="text-align: center;">Bold</td>
		<td style="text-align: center;">Normal</td>
		<td style="text-align: center;">Cursive</td>
		<td style="text-align: center;">Bold</td>
	</td>
</table>
<h6>C2 (čtvrtá akce)</h6>
<table style="margin:0px auto;width:60%">
	<tr style="">
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Insert</td>
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Insert</td>
		<td style="text-align: center;">Delete</td>
	</td>
	<tr style="">
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Insert</td>
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Insert</td>
	</td>
	<tr style="">
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Insert</td>
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Insert</td>
	</td>
	<tr style="">
		<td style="text-align: center;">Insert</td>
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Insert</td>
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Delete</td>
	</td>
	<tr style="">
		<td style="text-align: center;">Insert</td>
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Delete</td>
		<td style="text-align: center;">Insert</td>
		<td style="text-align: center;">Delete</td>
	</td>
</table>
<h6>C3 (pátá akce)</h6>
<table style="margin:0px auto;width:60%">
	<tr style="">
		<td style="text-align: center;">JumpStart</td>
		<td style="text-align: center;">JumpEnd</td>
		<td style="text-align: center;">PageUp</td>
		<td style="text-align: center;">JumpStart</td>
		<td style="text-align: center;">JumpEnd</td>
	</td>
	<tr style="">
		<td style="text-align: center;">JumpStart</td>
		<td style="text-align: center;">JumpEnd</td>
		<td style="text-align: center;">JumpStart</td>
		<td style="text-align: center;">JumpEnd</td>
		<td style="text-align: center;">PageUp</td>
	</td>
	<tr style="">
		<td style="text-align: center;">JumpEnd</td>
		<td style="text-align: center;">PageUp</td>
		<td style="text-align: center;">JumpStart</td>
		<td style="text-align: center;">JumpEnd</td>
		<td style="text-align: center;">JumpStart</td>
	</td>
	<tr style="">
		<td style="text-align: center;">JumpEnd</td>
		<td style="text-align: center;">JumpStart</td>
		<td style="text-align: center;">JumpEnd</td>
		<td style="text-align: center;">PageUp</td>
		<td style="text-align: center;">JumpStart</td>
	</td>
	<tr style="">
		<td style="text-align: center;">PageUp</td>
		<td style="text-align: center;">JumpStart</td>
		<td style="text-align: center;">JumpEnd</td>
		<td style="text-align: center;">JumpStart</td>
		<td style="text-align: center;">JumpEnd</td>
	</td>
</table>
<h6>C4 (šestá akce)</h6>
<table style="margin:0px auto;width:60%">
	<tr style="">
		<td style="text-align: center;">Save</td>
		<td style="text-align: center;">SaveAs</td>
		<td style="text-align: center;">Cancel</td>
		<td style="text-align: center;">Save</td>
		<td style="text-align: center;">SaveAs</td>
	</td>
	<tr style="">
		<td style="text-align: center;">SaveAs</td>
		<td style="text-align: center;">Save</td>
		<td style="text-align: center;">SaveAs</td>
		<td style="text-align: center;">Cancel</td>
		<td style="text-align: center;">Save</td>
	</td>
	<tr style="">
		<td style="text-align: center;">Save</td>
		<td style="text-align: center;">SaveAs</td>
		<td style="text-align: center;">Save</td>
		<td style="text-align: center;">SaveAs</td>
		<td style="text-align: center;">Cancel</td>
	</td>
	<tr style="">
		<td style="text-align: center;">Cancel</td>
		<td style="text-align: center;">Save</td>
		<td style="text-align: center;">SaveAs</td>
		<td style="text-align: center;">Save</td>
		<td style="text-align: center;">SaveAs</td>
	</td>
	<tr style="">
		<td style="text-align: center;">SaveAs</td>
		<td style="text-align: center;">Cancel</td>
		<td style="text-align: center;">Save</td>
		<td style="text-align: center;">SaveAs</td>
		<td style="text-align: center;">Save</td>
	</td>
</table>
<div style="height: 9em"></div>

<div class="page-break" />

##### Testovací případy

<table>
	<thead>
		<tr>
			<th>Test case</th>
			<th>Akce 1</th>
			<th>Akce 2</th>
			<th>Akce 3</th>
			<th>Akce 4</th>
			<th>Akce 5</th>
			<th>Akce 6</th>
		</tr>
	<thead>
	<tbody>
		<tr><th>1</th><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td></tr>
		<tr><th>2</th><td>0</td><td>1</td><td>1</td><td>1</td><td>1</td><td>1</td></tr>
		<tr><th>3</th><td>0</td><td>2</td><td>2</td><td>2</td><td>2</td><td>2</td></tr>
		<tr><th>4</th><td>0</td><td>3</td><td>3</td><td>3</td><td>3</td><td>3</td></tr>
		<tr><th>5</th><td>0</td><td>4</td><td>4</td><td>4</td><td>4</td><td>4</td></tr>
		<tr><th>6</th><td>1</td><td>0</td><td>1</td><td>2</td><td>3</td><td>4</td></tr>
		<tr><th>7</th><td>1</td><td>1</td><td>2</td><td>3</td><td>4</td><td>0</td></tr>
		<tr><th>8</th><td>1</td><td>2</td><td>3</td><td>4</td><td>0</td><td>1</td></tr>
		<tr><th>9</th><td>1</td><td>3</td><td>4</td><td>0</td><td>1</td><td>2</td></tr>
		<tr><th>10</th><td>1</td><td>4</td><td>0</td><td>1</td><td>2</td><td>3</td></tr>
		<tr><th>11</th><td>2</td><td>0</td><td>2</td><td>4</td><td>1</td><td>3</td></tr>
		<tr><th>12</th><td>2</td><td>1</td><td>3</td><td>0</td><td>2</td><td>4</td></tr>
		<tr><th>13</th><td>2</td><td>2</td><td>4</td><td>1</td><td>3</td><td>0</td></tr>
		<tr><th>14</th><td>2</td><td>3</td><td>0</td><td>2</td><td>4</td><td>1</td></tr>
		<tr><th>15</th><td>2</td><td>4</td><td>1</td><td>3</td><td>0</td><td>2</td></tr>
		<tr><th>16</th><td>3</td><td>0</td><td>3</td><td>1</td><td>4</td><td>2</td></tr>
		<tr><th>17</th><td>3</td><td>1</td><td>4</td><td>2</td><td>0</td><td>3</td></tr>
		<tr><th>18</th><td>3</td><td>2</td><td>0</td><td>3</td><td>1</td><td>4</td></tr>
		<tr><th>19</th><td>3</td><td>3</td><td>1</td><td>4</td><td>2</td><td>0</td></tr>
		<tr><th>20</th><td>3</td><td>4</td><td>2</td><td>0</td><td>3</td><td>1</td></tr>
		<tr><th>21</th><td>4</td><td>0</td><td>4</td><td>3</td><td>2</td><td>1</td></tr>
		<tr><th>22</th><td>4</td><td>1</td><td>0</td><td>4</td><td>3</td><td>2</td></tr>
		<tr><th>23</th><td>4</td><td>2</td><td>1</td><td>0</td><td>4</td><td>3</td></tr>
		<tr><th>24</th><td>4</td><td>3</td><td>2</td><td>1</td><td>0</td><td>4</td></tr>
		<tr><th>25</th><td>4</td><td>4</td><td>3</td><td>2</td><td>1</td><td>0</td></tr>
	</tbody>
</table>

<div class="page-break" />

Po nahrazení číselných hodnot jejich textovou reprezentací z jednotlivých matic získáme:

<table>
	<thead>
	<tr>
		<th>Test case</th>
		<th>Akce 1</th>
		<th>Akce 2</th>
		<th>Akce 3</th>
		<th>Akce 4</th>
		<th>Akce 5</th>
		<th>Akce 6</th>
	</tr>
	</thead>
	<tbody>
		<tr><th>1</th><td>New</td><td>SelectLine</td><td>Bold</td><td>Delete</td><td>JumpStart</td><td>Save</td></tr>
		<tr><th>2</th><td>New</td><td>SelectAll</td><td>Normal</td><td>Insert</td><td>JumpEnd</td><td>SaveAs</td></tr>
		<tr><th>3</th><td>New</td><td>SelectChar</td><td>Cursive</td><td>Delete</td><td>PageUp</td><td>Cancel</td></tr>
		<tr><th>4</th><td>New</td><td>SelectLine</td><td>Bold</td><td>Insert</td><td>JumpStart</td><td>Save</td></tr>
		<tr><th>5</th><td>New</td><td>SelectAll</td><td>Normal</td><td>Delete</td><td>JumpEnd</td><td>SaveAs</td></tr>
		<tr><th>6</th><td>Open</td><td>SelectLine</td><td>Normal</td><td>Delete</td><td>JumpStart</td><td>SaveAs</td></tr>
		<tr><th>7</th><td>Open</td><td>SelectAll</td><td>Cursive</td><td>Insert</td><td>JumpEnd</td><td>Save</td></tr>
		<tr><th>8</th><td>Open</td><td>SelectChar</td><td>Bold</td><td>Delete</td><td>JumpStart</td><td>SaveAs</td></tr>
		<tr><th>9</th><td>Open</td><td>SelectLine</td><td>Normal</td><td>Delete</td><td>JumpEnd</td><td>Cancel</td></tr>
		<tr><th>10</th><td>Open</td><td>SelectAll</td><td>Bold</td><td>Insert</td><td>PageUp</td><td>Save</td></tr>
		<tr><th>11</th><td>New</td><td>SelectLine</td><td>Cursive</td><td>Delete</td><td>JumpEnd</td><td>Save</td></tr>
		<tr><th>12</th><td>New</td><td>SelectAll</td><td>Bold</td><td>Delete</td><td>PageUp</td><td>SaveAs</td></tr>
		<tr><th>13</th><td>New</td><td>SelectChar</td><td>Normal</td><td>Insert</td><td>JumpStart</td><td>Save</td></tr>
		<tr><th>14</th><td>New</td><td>SelectLine</td><td>Bold</td><td>Delete</td><td>JumpEnd</td><td>SaveAs</td></tr>
		<tr><th>15</th><td>New</td><td>SelectAll</td><td>Normal</td><td>Insert</td><td>JumpStart</td><td>Cancel</td></tr>
		<tr><th>16</th><td>Open</td><td>SelectLine</td><td>Bold</td><td>Insert</td><td>JumpEnd</td><td>Cancel</td></tr>
		<tr><th>17</th><td>Open</td><td>SelectAll</td><td>Normal</td><td>Delete</td><td>JumpStart</td><td>Save</td></tr>
		<tr><th>18</th><td>Open</td><td>SelectChar</td><td>Bold</td><td>Insert</td><td>JumpEnd</td><td>SaveAs</td></tr>
		<tr><th>19</th><td>Open</td><td>SelectLine</td><td>Normal</td><td>Delete</td><td>PageUp</td><td>Save</td></tr>
		<tr><th>20</th><td>Open</td><td>SelectAll</td><td>Cursive</td><td>Delete</td><td>JumpStart</td><td>SaveAs</td></tr>
		<tr><th>21</th><td>New</td><td>SelectLine</td><td>Normal</td><td>Insert</td><td>PageUp</td><td>SaveAs</td></tr>
		<tr><th>22</th><td>New</td><td>SelectAll</td><td>Bold</td><td>Delete</td><td>JumpStart</td><td>Cancel</td></tr>
		<tr><th>23</th><td>New</td><td>SelectChar</td><td>Normal</td><td>Delete</td><td>JumpEnd</td><td>Save</td></tr>
		<tr><th>24</th><td>New</td><td>SelectLine</td><td>Cursive</td><td>Insert</td><td>JumpStart</td><td>SaveAs</td></tr>
		<tr><th>25</th><td>New</td><td>SelectAll</td><td>Bold</td><td>Delete</td><td>JumpEnd</td><td>Save</td></tr>
	</tbody>
</table>


##### Slovní popis testovacího případu 1
Proveď v editoru akce v posloupnosti New, SelectLine, Bold, Delete, JumpStart a Save.

[yrk]: http://www.york.ac.uk/depts/maths/tables/orthogonal.htm "Orthogonal Arrays (Taguchi Designs)"
[slides]: https://cw.fel.cvut.cz/wiki/_media/courses/a4m33tvs/prednasky/02.optimalizace.pdf "Optimalizace sady testů"
