//This file was generated from (Commercial) UPPAAL 4.0.14 (rev. 5615), May 2014

/*

*/
A[] not deadlock

/*

*/
A<> clanek.SUBMITTED imply (autor.IN_DRAFT and nakladatelstvi.MA_TO_AUTOR)

/*

*/
A<> clanek.DRAFT imply (autor.IN_DRAFT and nakladatelstvi.MA_TO_AUTOR)

/*

*/
A<> nakladatelstvi.REJECTED imply (clanek.REJECTED and autor.REJECTED)

/*

*/
A<> autor.REJECTED imply (clanek.REJECTED and nakladatelstvi.REJECTED)

/*

*/
A<> clanek.REJECTED imply (autor.REJECTED and nakladatelstvi.REJECTED)

/*

*/
E<> clanek.REJECTED

/*

*/
E<> clanek.PUBLISHED

/*

*/
E<> clanek.WAITING

/*

*/
E<> clanek.SUBMITTED

/*

*/
E<> clanek.DRAFT

/*

*/
A[] clanek.WAITING imply publish_wait_time>0

/*

*/
A[] !clanek.WAITING imply publish_wait_time==0

/*

*/
A[] clanek.WAITING imply nakladatelstvi.WAITING

/*

*/
A[] clanek.PUBLISHED imply nakladatelstvi.PUBLISHED

/*
should be red
*/
E<> deadlock
