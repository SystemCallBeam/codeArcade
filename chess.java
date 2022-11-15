import java.util.Scanner;

class chess {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String pos = in.nextLine();
    String date[] = in.nextLine().split(" ");
    in.close();
    String stt[] = date[0].split("/");
    String end[] = date[2].split("/");

    int nEnd = compute(
      Integer.valueOf(end[0]),
      Integer.valueOf(end[1]),
      Integer.valueOf(end[2])
    );
    int nStt = compute(
      Integer.valueOf(stt[0]),
      Integer.valueOf(stt[1]),
      Integer.valueOf(stt[2])
    );
    int n = nEnd - nStt + 1;
    System.out.println(n);
    int i = pos.charAt(0) - 'a' + 1, j = pos.charAt(1) - '0';
    step(n, i, j);
  }

  static void step(int n, int X, int Y) {
    while (n > 0) {
      n--;
      if (Y <= 4 && X <= 4 && Y < X) {
        Y += 2;
        X += 1;
      } else if (Y <= 4 && X <= 4 && Y >= X) {
        Y += 1;
        X += 2;
      } else if (Y <= 4 && X > 4 && 8 - Y >= X) {
        Y += 2;
        X -= 1;
      } else if (Y <= 4 && X > 4 && 8 - Y < X) {
        Y += 1;
        X -= 2;
      } else if (Y > 4 && X <= 4 && Y > 9 - X) {
        Y -= 2;
        X += 1;
      } else if (Y > 4 && X <= 4 && Y <= 9 - X) {
        Y -= 1;
        X += 2;
      } else if (Y > 4 && X > 4 && Y > X) {
        Y -= 2;
        X -= 1;
      } else if (Y > 4 && X > 4 && Y <= X) {
        Y -= 1;
        X -= 2;
      }
    }
    System.out.printf("%c%d\n", X + 'a' - 1, Y);
  }

  static int compute(int dd, int mm, int yy) {
    int leap = 0;
    if (yy % 400 == 0 || (yy % 100 != 0 && yy % 4 == 0)) {
      System.out.println("leap");
      leap = 1;
    }
    yy--;
    int sum[] = {
      365,
      31,
      59 + leap,
      90 + leap,
      120 + leap,
      151 + leap,
      181 + leap,
      212 + leap,
      243 + leap,
      273 + leap,
      304 + leap,
      334 + leap,
    };
    int ans =
      (yy * 365) + (yy / 4) - (yy / 100) + (yy / 400) + sum[mm - 1] + dd;
    return ans;
    // int sum[] = { 365, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
    // int ans = (yy * 365) + yy / 4 - yy / 100 + yy / 400 + sum[mm] + dd;
    // if (yy % 400 == 0 || yy % 100 != 0 && yy % 4 == 0 && mm > 2) ans++;
    // return ans;
  }
}
