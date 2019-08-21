package dev.entze.sge.agent.randomagent;

import dev.entze.sge.agent.GameAgent;
import dev.entze.sge.engine.Logger;
import dev.entze.sge.game.Game;
import dev.entze.sge.util.Util;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomAgent<G extends Game<A, ?>, A> implements GameAgent<G, A> {

  private static int INSTANCE_NR_COUNTER = 1;

  private final Logger log;
  private final Random random;
  private final int instanceNr;

  public RandomAgent() {
    this(new Random(), null);
  }

  public RandomAgent(Logger log) {
    this(new Random(), log);
  }

  public RandomAgent(Random random, Logger log) {
    this.random = random;
    this.log = log;
    this.instanceNr = INSTANCE_NR_COUNTER++;
  }

  @Override
  public A computeNextAction(G game, long computationTime, TimeUnit timeUnit) {
    return Util.selectRandom(game.getPossibleActions(), random);
  }

  @Override
  public String toString() {
    return String.format("%s%d", "RandomAgent#", instanceNr);
  }
}
