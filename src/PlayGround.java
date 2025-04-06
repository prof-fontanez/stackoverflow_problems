
public class PlayGround {

  int value = 3;

  public static void main(String[] args) {
    PlayGround.PlayGroundSon pg = new PlayGround().new PlayGroundSon();
    System.out.println("value is "+ pg.value);
  }

  class PlayGroundSon extends PlayGround{
    int value = 5;
  }
}