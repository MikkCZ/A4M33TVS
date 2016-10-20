<style>
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
</style>

<h1>Strukturální testování - řídicí tok</h1>
Skupina: <strong>10</strong>

Řešitelé: <strong>Stanke Michal</strong>, <strong>Timr Marek</strong>, <strong>Voříšek Lukáš</strong>

<h2>Zadání úlohy</h2>
<p>Následující zdrojový Java kód funkce převeďte na graf řídicího toku. Metodou
hlavních cest sestrojte sadu testovacích cest, které plně pokryjí daný kód.</p>

<pre>
public int fnc() {
  B999();
  while( B0() ) {
    B7();
  }
  if( B1() ) then {
    B2();
  }
  else {
    B6();
  }
  while( B3() ) {
    B4();
  }
  B5();
}
</pre>

<div class="labeled-img">
  <img src="graph.png"/>
  <span class="label">obrázek 1 - Model řídícího toku</span>
</div>
