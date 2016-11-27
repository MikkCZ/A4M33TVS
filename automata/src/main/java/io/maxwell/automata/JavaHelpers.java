package io.maxwell.automata;

import scala.Option;
import scala.collection.mutable.MutableList;

import java.util.List;

/**
 * @author Vorisek Lukas <lukasvorisek@gmail.com>
 */
public class JavaHelpers {

    static public <N> void forAll(MutableList<N> list, DoCommand<N> command) {
        for(int k = 0; k < list.length(); k++) {
            command.doCommand(list.get(k), k);
        }
    }

    @FunctionalInterface
    public interface DoCommand<N> {
        public void doCommand(Option<N> element, int index);
    }
}
