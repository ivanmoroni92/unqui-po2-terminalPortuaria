public interface ISearchStrategy {
    // el metodo search devolvera el mejor travel entre la terminal origen ( nuestra managedTerminal) y una terminal desitno
    // el concepto de mejor sera seteado en base a una estrategia que decide la terminal
     Travel search(ManagedTerminal origenTerminal, Terminal destinyTerminal);


}
