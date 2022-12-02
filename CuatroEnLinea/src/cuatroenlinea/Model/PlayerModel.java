package cuatroenlinea.Model;


public class PlayerModel {
  private String name;
  private int scores;

  public PlayerModel(String name, int scores) {
    this.name = name;
    this.scores = scores;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScores() {
    return scores;
  }

  public void setScores(int scores) {
    this.scores = scores;
  }

  public String toJson() {
    return "{\"name\": \"" + name + "\", \"scores\" : " + scores + "}";
  }

  @Override
  public String toString() {
    return "PlayerEntity (name: " + name + ", scores:" + scores + ") ";
  }
}
