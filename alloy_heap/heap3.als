module Heap
open util/ordering[Level] as LO
open util/ordering[Node] as NO


sig Node {
	level: one Level,
	p: lone Node,
	l: lone Node,
	r: lone Node,
	v: one Int
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

fact JineHodnoty {
	all n : Node | all m : Node | n != m => n.v != m.v
}

fact VsechnyHodnotyKladne {
	all n : Node | n.v >= 0
}

fact VlastnostMaxHepy {
	all n : Node | one n.p => n.p.v >= n.v
}


run {} for exactly 6 Node, 4 Level, 5 Int
