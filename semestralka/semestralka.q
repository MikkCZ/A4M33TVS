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
pokud je clanek ve stavu WAITING, pak je nastaveny i cas cekani
*/
A[] clanek.WAITING imply publish_wait_time>0

/*
pokud clanek neni ve stavu WAITING, pak je nastaveny cas cekani na 0
*/
A[] !clanek.WAITING imply publish_wait_time==0
