module Heap
open util/ordering[Level] as LO
open util/ordering[Node] as NO

// Signatura uzlu, obsahuje svou hloubku (level), rodice (p), potomky (l,r), hodnotu (v) a uzel nasledujici v poradi (nn).
sig Node {
	level: one Level,
	p: lone Node,
	l: lone Node,
	r: lone Node,
	v: one Int,
	nn: lone Node
}

// Signatura hloubky uzlu.
sig Level {}

// Halda ma pouze jeden koren.
// = existuje jen jeden uzel, ktery nema rodice
// = vsechny uzly, ktere nemaji rodice, jsou v poradi uzlu prvni
// = vsechny uzly, ktere nemaji rodice, jsou nejvyse (v koreni stromu)
fact JedenRoot {
	one n : Node | no n.p
	all n : Node | no n.p => n = NO/first
	all n : Node | no n.p => n.level = LO/first
}

// Rodic je vzdy ve stromu vyse nez jeho potomek.
fact RodicMaMensiLevel {
	all n : Node | one n.p => n.level = LO/next[n.p.level]
}

// Potomek ma odkaz na spraveneho rodice.
// = kazdy uzel (n) ma potomka (p i l) takoveho, ze jeho rodicem je opet tento uzel (n)
// = pravy (p) a levy (l) potomek uzlu (n) nejsou shodne
fact DiteJeVRodici {
	all n : Node | one n.l => n.l.p = n
	all n : Node | one n.r => n.r.p = n
	all n : Node | one n.r && one n.l => n.r != n.l
}

// Pokud ma uzel praveho potomka, ma i leveho (plneni haldy zleva).
fact NejprveLeve {
	all n : Node | one n.r => one n.l
}

// Ke kazdemu uzlu (n), ktery ma rodice, existuje uzel rodice, pro ktereho je levym nebo pravym potomkem.
// = prunik (n) a levym a pravym potomkem jeho rodice je jeden
fact JePotomek {
	all n : Node | one n.p => one (n & (n.p.l + n.p.r))
}

// Zadny uzel neni svym vlastnim rodicem ani potomkem.
// = neni uzel takovy, aby byl obsazen v mnozine sveho rodice, jeho rodice, atd.
// = neni uzel takovy, aby byl obsazen v mnozine potomku svych potomku
fact NeniVlastniRodicAniPotomek {
	no n : Node | n in n.^p
	no n : Node | n in (n.l.^(r + l) + n.r.^(r + l))

}

// Halda je zhora plna.
// = pro vsechny dvojice uzlu (m,n) plati, ze je-li m o uroven hloubeji nez m, ma m praveho i leveho potomka
fact PlnyPredchoziLevel {
	all n : Node | all m : Node | one n.l && n.level = LO/next[m.level] => #(m.r + m.l) = 2
}

// Spodni patro haldy se plni zleva.
// = pro vsechny uzly (n) plati, ze maji-li oba potomky, pak pravy nasleduje po levem
// = pro vsechny uzly (n) plati, ze maji-li predchozi uzel a leveho potomka, pak ten nasleduje za nimi
fact PlniSeZLeva {
	all n : Node | one n.l && one n.r => n.l.next = n.r
	all n : Node | one NO/prev[n] && one n.l => NO/prev[n].r.next = n.l
}

// Zadne dva ruzne uzly nemaji stejnou hodnotu.
fact JineHodnoty {
	all n : Node | all m : Node | n != m => n.v != m.v
}

// Vsechny hodnoty jsou kladne.
fact VsechnyHodnotyKladne {
	all n : Node | n.v >= 0
}

// Hodnota v kazdem uzlu je mensi nez hodnota jeho rodice.
fact VlastnostMaxHepy {
	all n : Node | one n.p => n.p.v >= n.v
}

// V kazdem uzlu odpovida nn nasledujicimu uzlu v poradi.
fact Next {
	all n : Node | n.nn = NO/next[n]
}

// Assert: Existuje nanejvys jeden uzel, ktery ma jenom leveho potomka a nema praveho.
pred jedinacek[] {
	lone n: Node | one n.l && no n.r
}
// Assert: Existuje jenom jeden uzel, ktery nema rodice.
pred oneRoot[] {
	one d: Node | no d.p
}
// Assert: Neexistuje zadny uzel, jehoz hodnota by byla vyssi nez hodnota v jeho rodici, pokud jej ma.
pred[] PotomekMensiNezRodic {
	 no n : Node | one n.p && n.v > n.p.v
}

check {jedinacek and oneRoot and PotomekMensiNezRodic} for 12 Node, 5 Level,8 Int
check oneRoot for 12 Node, 5 Level,8 Int
check PotomekMensiNezRodic for 12 Node, 5 Level,4 Int

//run {} for exactly 6 Node, 4 Level, 5 Int
//run {} for exactly 4 Node, 3 Level, 5 Int
