//This file was generated from (Commercial) UPPAAL 4.0.14 (rev. 5615), May 2014

/*
existuje deadlock - jedine ma byt cervene
*/
E<> deadlock

/*
nikdy nenastane deadlock
*/
A[] not deadlock

/*
clanek ma autor
*/
A[] nakladatelstvi.MA_TO_AUTOR imply (clanek.DRAFT or clanek.SUBMITTED or clanek.INITIAL)

/*
clanek ma vydavatel
*/
A[] autor.MA_TO_VYDAVATEL imply (clanek.PUBLISHED or clanek.WAITING)

/*
clanek je PUBLISHED vsude (1)
*/
A[] nakladatelstvi.PUBLISHED imply (autor.MA_TO_VYDAVATEL and clanek.PUBLISHED)

/*
clanek je PUBLISHED vsude (2)
*/
A[] clanek.PUBLISHED imply (autor.MA_TO_VYDAVATEL and nakladatelstvi.PUBLISHED)

/*
clanek je WAITING vsude (1)
*/
A[] nakladatelstvi.WAITING imply (autor.MA_TO_VYDAVATEL and clanek.WAITING)

/*
clanek je WAITING vsude (2)
*/
A[] clanek.WAITING imply (autor.MA_TO_VYDAVATEL and nakladatelstvi.WAITING)

/*
clanek je SUBMITTED vsude (1)
*/
A[] nakladatelstvi.SUBMITTED imply (autor.SUBMITTED and clanek.SUBMITTED)

/*
clanek je SUBMITTED vsude (2)
*/
A[] autor.SUBMITTED imply (clanek.SUBMITTED and nakladatelstvi.SUBMITTED)

/*
clanek je SUBMITTED vsude (3)
*/
A[] clanek.SUBMITTED imply (autor.SUBMITTED and nakladatelstvi.SUBMITTED)

/*
clanek je DRAFT vsude (1)
*/
A[] autor.DRAFT imply (clanek.DRAFT and nakladatelstvi.MA_TO_AUTOR)

/*
clanek je DRAFT vsude (2)
*/
A[] clanek.DRAFT imply (autor.DRAFT and nakladatelstvi.MA_TO_AUTOR)

/*
clanek je REJECTED vsude (1)
*/
A[] nakladatelstvi.REJECTED imply (clanek.REJECTED and autor.REJECTED)

/*
clanek je REJECTED vsude (2)
*/
A[] autor.REJECTED imply (clanek.REJECTED and nakladatelstvi.REJECTED)

/*
clanek je REJECTED vsude (2)
*/
A[] clanek.REJECTED imply (autor.REJECTED and nakladatelstvi.REJECTED)

/*
clanek muze byt ve stavu REJECTED
*/
E<> clanek.REJECTED

/*
clanek muze byt ve stavu PUBLISHED
*/
E<> clanek.PUBLISHED

/*
clanek muze byt ve stavu WAITING
*/
E<> clanek.WAITING

/*
clanek muze byt ve stavu SUBMITTED
*/
E<> clanek.SUBMITTED

/*
clanek muze byt ve stavu DRAFT
*/
E<> clanek.DRAFT

/*
clanek muze cekat az do nastaveneho wait time
*/
E<> clanek.WAITING and clanek.clk == publish_wait_time

/*
clanek muze cekat az do maximalniho wait time
*/
E<> clanek.WAITING and clanek.clk == nakladatelstvi.MAX_WAIT

/*
clanek nikdy nebude cekat dele nez je maximalni wait time
*/
E<> clanek.WAITING and !(clanek.clk > nakladatelstvi.MAX_WAIT)

/*
pokud je clanek ve stavu WAITING, pak je nastaveny i cas cekani
*/
A[] clanek.WAITING imply publish_wait_time>0

/*
do stavu PUBLISHED se lze dostat bez cekani
*/
E<> clanek.PUBLISHED imply publish_wait_time==0

/*
do stavu PUBLISHED se lze dostat po nejakem cekani
*/
E<> clanek.PUBLISHED and publish_wait_time>0

/*
pokud se clanek dostane do stavu PUBLISHED z WAITING, doba cekani jiz ubehla
*/
A[] (clanek.PUBLISHED and publish_wait_time>0) imply (clanek.clk>=publish_wait_time)

/*
pokud clanek neni ve stavu WAITING ani PUBLISHED, pak je nastaveny cas cekani na 0
*/
A[] !(clanek.WAITING or clanek.PUBLISHED) imply publish_wait_time==0
