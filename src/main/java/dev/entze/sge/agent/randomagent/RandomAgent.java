package dev.entze.sge.agent.randomagent;

import dev.entze.sge.agent.GameAgent;
import dev.entze.sge.game.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomAgent<G extends Game<? extends A, ?>, A> implements GameAgent<G, A> {

  private final Random random;

  public RandomAgent() {
    this(new Random());
  }

  public RandomAgent(Random random) {
    this.random = random;
  }

  @Override
  public A computeNextAction(G game, long computationTime, TimeUnit timeUnit) {
    List<A> possibleActions = new ArrayList<>(game.getPossibleActions());
    return possibleActions.get(random.nextInt(possibleActions.size()));
  }

  @Override
  public String toString() {
    return "RandomAgent";
  }
}
