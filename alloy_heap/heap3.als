module Heap
open util/ordering[Level] as LO
open util/ordering[Node] as NO

sig Node {
	level: one Level,
	p: lone Node,
	l: lone Node,
	r: lone Node,
	v: one Int,
	nn: lone Node
}

sig Level {}

fact JedenRoot {
	one n : Node | no n.p
	all n : Node | no n.p => n = NO/first
	all n : Node | no n.p => n.level = LO/first
}

fact RodicMaMensiLevel {
	all n : Node | one n.p => n.level = LO/next[n.p.level]
}

fact DiteJeVRodici {
	all n : Node | one n.l => n.l.p = n
	all n : Node | one n.r => n.r.p = n
	all n : Node | one n.r && one n.l => n.r != n.l
}

fact NejprveLeve {
	all n : Node | one n.r => one n.l
}

fact JePotomek {
	all n : Node | one n.p => one (n & (n.p.l + n.p.r))
}

fact NeniVlastniRodicAniPotomek {
	no n : Node | n in n.^p
	no n : Node | n in (n.l.^(r + l) + n.r.^(r + l))
	
}

fact PlnyPredchoziLevel {
	all n : Node | all m : Node | one n.l && n.level = LO/next[m.level] => #(m.r + m.l) = 2
}

fact PlniSeZLeva {
	all n : Node | one n.l && one n.r => n.l.next = n.r
	all n : Node | one NO/prev[n] && one n.l => NO/prev[n].r.next = n.l
}

fact JineHodnoty {
	all n : Node | all m : Node | n != m => n.v != m.v
}

fact VsechnyHodnotyKladne {
	all n : Node | n.v >= 0
}

fact VlastnostMaxHepy {
	all n : Node | one n.p => n.p.v >= n.v
}

fact Next {
	all n : Node | n.nn = NO/next[n]
}

//existuje nanejvys jeden node, ktery ma jenom leveho potomka
// Tohle vypada hodne dobre
assert jedinacek { 
	lone n: Node | one n.l && no n.r
}
assert oneRoot {
	one d: Node | no d.p
}
assert PotomekMensiNezRodic {
	 no n : Node | one n.p && n.v > n.p.v 
}


check jedinacek for 12 Node, 5 Level,8 Int
check oneRoot for 12 Node, 5 Level,8 Int
check PotomekMensiNezRodic for 12 Node, 5 Level,4 Int

//run {} for exactly 6 Node, 4 Level, 5 Int
//run {} for exactly 4 Node, 3 Level, 5 Int
