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

### Instrukce s pěti parametry
Pro instrukci s pěti parametry jsme se rozhodli vybrat ortogonální pole L16b ze stránek univerzity v Yorku, konkrétně pak ze stránky [Orthogonal Arrays][yrk]. L16b je pole pro až pět parametrů se čtyřmi úrovněmi.
<div style="height: 200px"></div>

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

##### Slovník parametrů
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

##### Tabulka testovacích případů
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

##### Slovní popis testovacího případu 16
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

##### Identifikace parametrů a významných hodnot
parametry = pozice v sekvenci
významné hodnoty = možné akce na jednotlivých pozicích (podle zadání)
##### Volba čtverce
V úloze jsme potřebovali do čtverce zakódovat až tři významné hodnoty a zároveň šest parametrů. Podle "pravidla" n+1 jsme tak zvolili n=5 a použili čtyři čtverce 5x5 z [přednáškových slajdů][slides].

##### Latinské čtverce
###### C1
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
###### C2
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
###### C3
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
###### C4
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

##### Tabulka pro interpretaci číselných hodnot z latinských čtverců
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

##### Latinské čtverce s významnými hodnotami
###### C1 (třetí akce)
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
###### C2 (čtvrtá akce)
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
###### C3 (pátá akce)
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
###### C4 (šestá akce)
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
<div style="height: 1em"></div>

##### Testovací případy
1. *0, 0, 0, 0, 0, 0: New -> SelectLine -> Bold -> Delete -> JumpStart -> Save*
1. *0, 1, 1, 1, 1, 1: New -> SelectAll -> Normal -> Insert -> JumpEnd -> SaveAs*
1. *0, 2, 2, 2, 2, 2: New -> SelectChar -> Cursive -> Delete -> PageUp -> Cancel*
1. *0, 3, 3, 3, 3, 3: New -> SelectLine -> Bold -> Insert -> JumpStart -> Save*
1. *0, 4, 4, 4, 4, 4: New -> SelectAll -> Normal -> Delete -> JumpEnd -> SaveAs*
1. *1, 0, 1, 2, 3, 4: Open -> SelectLine -> Normal -> Delete -> JumpStart -> SaveAs*
1. *1, 1, 2, 3, 4, 0: Open -> SelectAll -> Cursive -> Insert -> JumpEnd -> Save*
1. *1, 2, 3, 4, 0, 1: Open -> SelectChar -> Bold -> Delete -> JumpStart -> SaveAs*
1. *1, 3, 4, 0, 1, 2: Open -> SelectLine -> Normal -> Delete -> JumpEnd -> Cancel*
1. *1, 4, 0, 1, 2, 3: Open -> SelectAll -> Bold -> Insert -> PageUp -> Save*
1. *2, 0, 2, 4, 1, 3: New -> SelectLine -> Cursive -> Delete -> JumpEnd -> Save*
1. *2, 1, 3, 0, 2, 4: New -> SelectAll -> Bold -> Delete -> PageUp -> SaveAs*
1. *2, 2, 4, 1, 3, 0: New -> SelectChar -> Normal -> Insert -> JumpStart -> Save*
1. *2, 3, 0, 2, 4, 1: New -> SelectLine -> Bold -> Delete -> JumpEnd -> SaveAs*
1. *2, 4, 1, 3, 0, 2: New -> SelectAll -> Normal -> Insert -> JumpStart -> Cancel*
1. *3, 0, 3, 1, 4, 2: Open -> SelectLine -> Bold -> Insert -> JumpEnd -> Cancel*
1. *3, 1, 4, 2, 0, 3: Open -> SelectAll -> Normal -> Delete -> JumpStart -> Save*
1. *3, 2, 0, 3, 1, 4: Open -> SelectChar -> Bold -> Insert -> JumpEnd -> SaveAs*
1. *3, 3, 1, 4, 2, 0: Open -> SelectLine -> Normal -> Delete -> PageUp -> Save*
1. *3, 4, 2, 0, 3, 1: Open -> SelectAll -> Cursive -> Delete -> JumpStart -> SaveAs*
1. *4, 0, 4, 3, 2, 1: New -> SelectLine -> Normal -> Insert -> PageUp -> SaveAs*
1. *4, 1, 0, 4, 3, 2: New -> SelectAll -> Bold -> Delete -> JumpStart -> Cancel*
1. *4, 2, 1, 0, 4, 3: New -> SelectChar -> Normal -> Delete -> JumpEnd -> Save*
1. *4, 3, 2, 1, 0, 4: New -> SelectLine -> Cursive -> Insert -> JumpStart -> SaveAs*
1. *4, 4, 3, 2, 1, 0: New -> SelectAll -> Bold -> Delete -> JumpEnd -> Save*

##### Slovní popis testovacího případu 1
Proveď v editoru akce v posloupnosti New, SelectLine, Bold, Delete, JumpStart a Save.

[yrk]: http://www.york.ac.uk/depts/maths/tables/orthogonal.htm "Orthogonal Arrays (Taguchi Designs)"
[slides]: https://cw.fel.cvut.cz/wiki/_media/courses/a4m33tvs/prednasky/02.optimalizace.pdf "Optimalizace sady testů"
