package dev.entze.sge.agent.randomagent;

import dev.entze.sge.agent.GameAgent;
import dev.entze.sge.game.Game;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomAgent<G extends Game<A, ?>, A> implements GameAgent<G, A> {

  private final Random random;

  public RandomAgent() {
    this(new Random());
  }

  public RandomAgent(Random random) {
    this.random = random;
  }

  @Override
  public A calculateNextAction(G game, long calculationTime, TimeUnit timeUnit) {
    List<? extends A> possibleActions = game.getPossibleActions();
    return possibleActions.get(random.nextInt(possibleActions.size()));
  }

}
