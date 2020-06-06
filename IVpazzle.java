import java.util.*;
import java.io.*;
import java.nio.*;

public class IVpazzle{
  public static void main(String[] args) {
  int[] IV = new int[6];
  System.out.printf(" IVpazzle ver%1.1f%n ", 1.3);
  System.out.println("注:自然Vが発生している個体値はサポートされていません");
  System.out.println();
  System.out.println(" 2Vまたは3Vのポケモンの個体値を入力してください(例:x x x x x x)");
  String IVscan = new Scanner(System.in).nextLine();
  String Array[] = IVscan.split(" ");
  int H = Integer.parseInt(Array[0]);
  int A = Integer.parseInt(Array[1]);
  int B = Integer.parseInt(Array[2]);
  int C = Integer.parseInt(Array[3]);
  int D = Integer.parseInt(Array[4]);
  int S = Integer.parseInt(Array[5]);
  if (H < 0 || H > 31 || A < 0 || A > 31 || B < 0 || B > 31 || C < 0 || C > 31 || D < 0 || D > 31 || S < 0 || S > 31){
  System.out.println("値が不正です");
  System.exit(0);
}
  int lastNotV1num = 7;
  if (!(S == 31))
  lastNotV1num = 5;
  else if (!(D == 31))
  lastNotV1num = 4;
  else if (!(C == 31))
  lastNotV1num = 3;
  else if (!(B == 31))
  lastNotV1num = 2;
  else if (!(A == 31))
  lastNotV1num = 1;
  else if (!(H == 31))
  lastNotV1num = 0;

  int lastNotV1 = 999;
  if(lastNotV1num == 5)
  lastNotV1 = S;
  else if(lastNotV1num == 4)
  lastNotV1 = D;
  else if(lastNotV1num == 3)
  lastNotV1 = C;
  else if(lastNotV1num == 2)
  lastNotV1 = B;
  else if(lastNotV1num == 1)
  lastNotV1 = A;
  else if(lastNotV1num == 0)
  lastNotV1 = H;

  LinkedList<Integer> notV = new LinkedList<Integer>();
  if (!(H == 31))
  notV.add(H);
  if (!(A == 31))
  notV.add(A);
  if (!(B == 31))
  notV.add(B);
  if (!(C == 31))
  notV.add(C);
  if (!(D == 31))
  notV.add(D);
  if (!(S == 31))
  notV.add(S);

  int firstVcount = 0;
  if (H == 31)
  firstVcount++;
  if (A == 31)
  firstVcount++;
  if (B == 31)
  firstVcount++;
  if (C == 31)
  firstVcount++;
  if (D == 31)
  firstVcount++;
  if (S == 31)
  firstVcount++;

  if (!(H == 31) && (H % 8 == 0)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(H == 31) && (H % 8 == 1) && (A == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(H == 31) && (H % 8 == 2) && (B == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(H == 31) && (H % 8 == 3) && (C == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(H == 31) && (H % 8 == 4) && (D == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(H == 31) && (H % 8 == 5) && (S == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(H == 31) && ((H % 8 == 6) || (H % 8 == 7))){
    IV = recalc(H, A, B, C, D, S);
  }


  else if (!(A == 31) && (A % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 1)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(A == 31) && (A % 8 == 0) && (H == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(A == 31) && (A % 8 == 2) && (B == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(A == 31) && (A % 8 == 3) && (C == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(A == 31) && (A % 8 == 4) && (D == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(A == 31) && (A % 8 == 5) && (S == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(A == 31) && ((A % 8 == 6) || (A % 8 == 7))){
    IV = recalc(H, A, B, C, D, S);
  }


  else if (!(B == 31) && (B % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 2)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(B == 31) && (B % 8 == 0) && (H == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(B == 31) && (B % 8 == 1) && (A == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(B == 31) && (B % 8 == 3) && (C == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(B == 31) && (B % 8 == 4) && (D == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(B == 31) && (B % 8 == 5) && (S == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(B == 31) && ((B % 8 == 6) || (B % 8 == 7))){
    IV = recalc(H, A, B, C, D, S);
  }


  else if (!(C == 31) && (C % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 2) && !(H == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 3)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(C == 31) && (C % 8 == 0) && (H == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(C == 31) && (C % 8 == 1) && (A == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(C == 31) && (C % 8 == 2) && (B == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(C == 31) && (C % 8 == 4) && (D == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(C == 31) && (C % 8 == 5) && (S == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(C == 31) && ((C % 8 == 6) || (C % 8 == 7))){
    IV = recalc(H, A, B, C, D, S);
  }


  else if (!(D == 31) && (D % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(D == 31) && (D % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(D == 31) && (D % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(D == 31) && (D % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(D == 31) && (D % 8 == 4)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(D == 31) && (D % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(D == 31) && (D % 8 == 0) && (H == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(D == 31) && (D % 8 == 1) && (A == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(D == 31) && (D % 8 == 2) && (B == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(D == 31) && (D % 8 == 3) && (C == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(D == 31) && (D % 8 == 5) && (S == 31)){
    IV = recalc(H, A, B, C, D, S);
  }
  else if (!(D == 31) && ((D % 8 == 6) || (D % 8 == 7))){
    IV = recalc(H, A, B, C, D, S);
  }

  int secondVcount = 0;
  if (IV[0] == 31)
  secondVcount++;
  if (IV[1] == 31)
  secondVcount++;
  if (IV[2] == 31)
  secondVcount++;
  if (IV[3] == 31)
  secondVcount++;
  if (IV[4] == 31)
  secondVcount++;
  if (IV[5] == 31)
  secondVcount++;

  int unknownCount = 0;
  if (IV[0] > 31)
  unknownCount++;
  if (IV[1] > 31)
  unknownCount++;
  if (IV[2] > 31)
  unknownCount++;
  if (IV[3] > 31)
  unknownCount++;
  if (IV[4] > 31)
  unknownCount++;
  if (IV[5] > 31)
  unknownCount++;

  String firstNotV = "no select";
  if (!(IV[0] == 31))
  firstNotV = "H";
  else if (!(IV[1] == 31))
  firstNotV = "A";
  else if (!(IV[2] == 31))
  firstNotV = "B";
  else if (!(IV[3] == 31))
  firstNotV = "C";
  else if (!(IV[4] == 31))
  firstNotV = "D";
  else if (!(IV[5] == 31))
  firstNotV = "S";

  int lastNotV2num = 7;
  if (!(IV[5] == 31))
  lastNotV2num = 5;
  else if (!(IV[4] == 31))
  lastNotV2num = 4;
  else if (!(IV[3] == 31))
  lastNotV2num = 3;
  else if (!(IV[2] == 31))
  lastNotV2num = 2;
  else if (!(IV[1] == 31))
  lastNotV2num = 1;
  else if (!(IV[0] == 31))
  lastNotV2num = 0;

  int lastNotV2 = 999;
  if(lastNotV1num == 5)
  lastNotV2 = IV[5];
  else if(lastNotV2num == 4)
  lastNotV2 = IV[4];
  else if(lastNotV2num == 3)
  lastNotV2 = IV[3];
  else if(lastNotV2num == 2)
  lastNotV2 = IV[2];
  else if(lastNotV2num == 1)
  lastNotV2 = IV[1];
  else if(lastNotV2num == 0)
  lastNotV2 = IV[0];

  String Hst = "H";
  String Ast = "A";
  String Bst = "B";
  String Cst = "C";
  String Dst = "D";
  String Sst = "S";

  if ((((firstVcount == 2) && (unknownCount >= 1) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32)))
   || ((firstVcount == 3) && (unknownCount >= 2) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32))
   && ((IV[0] == 33) || (IV[1] == 33) || (IV[2] == 33) || (IV[3] == 33) || (IV[4] == 33) || (IV[5] == 33)))) && (firstVcount < secondVcount)){
  System.out.println("連続個体値を得られました。");
  for (int f = 0; f < notV.size(); f++){
  System.out.print(notV.get(f) + " ");
}
  if ((IV[0] == 32))
  System.out.print("[" + secondVcount + "V個体のH] ");
  if ((IV[1] == 32))
  System.out.print("[" + secondVcount + "V個体のA] ");
  if ((IV[2] == 32))
  System.out.print("[" + secondVcount + "V個体のB] ");
  if ((IV[3] == 32))
  System.out.print("[" + secondVcount + "V個体のC] ");
  if ((IV[4] == 32))
  System.out.print("[" + secondVcount + "V個体のD] ");
  if ((IV[5] == 32))
  System.out.print("[" + secondVcount + "V個体のS] ");
  if ((IV[0] == 33))
  System.out.print("[" + secondVcount + "V個体のH] ");
  if ((IV[1] == 33))
  System.out.print("[" + secondVcount + "V個体のA] ");
  if ((IV[2] == 33))
  System.out.print("[" + secondVcount + "V個体のB] ");
  if ((IV[3] == 33))
  System.out.print("[" + secondVcount + "V個体のC] ");
  if ((IV[4] == 33))
  System.out.print("[" + secondVcount + "V個体のD] ");
  if ((IV[5] == 33))
  System.out.print("[" + secondVcount + "V個体のS] ");
  System.out.println("の5つの個体値が連続個体値です。");
  Crash();
  System.exit(0);
}else{
  if ((secondVcount == 5) || (((IV[0] > 32) || (IV[1] > 32) || (IV[2] > 32) || (IV[3] > 32) || (IV[4] > 32) || (IV[5] > 32))
  && (!(IV[0] == 32) && !(IV[1] == 32) && !(IV[2] == 32) && !(IV[3] == 32) && !(IV[4] == 32) && !(IV[5] == 32)))){
  System.out.println("連続個体値を得られませんでした。");
  faleCounter();
  System.exit(0);
}
else if (((firstNotV.equals(Hst)) && (IV[0] > 31)) || ((firstNotV.equals(Ast)) && (IV[1] > 31)) || ((firstNotV.equals(Bst)) && (IV[2] > 31)) ||
        ((firstNotV.equals(Cst)) && (IV[3] > 31)) || ((firstNotV.equals(Dst)) && (IV[4] > 31)) || ((firstNotV.equals(Sst)) && (IV[5] > 31))){
  System.out.println("再計算回数が多すぎるため、連続個体値が得られているか判定できません");
  faleCounter();
  System.exit(0);
}else{
  H = IV[0]; A = IV[1]; B = IV[2]; C = IV[3]; D = IV[4]; S = IV[5];
  if (!(H == 31) && (H % 8 == 0)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(H == 31) && (H % 8 == 1) && (A == 31) ){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
  }
  else if (!(H == 31) && (H % 8 == 2) && (B == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 3) && (C == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 4) && (D == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 5) && (S == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && ((H % 8 == 6) || (H % 8 == 7))){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(A == 31) && (A % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 1)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(A == 31) && (A % 8 == 0) && (H == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 2) && (B == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 3) && (C == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 4) && (D == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 5) && (S == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && ((A % 8 == 6) || (A % 8 == 7))){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(B == 31) && (B % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 2)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(B == 31) && (B % 8 == 0) && (H == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 1) && (A == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 3) && (C == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 4) && (D == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 5) && (S == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && ((B % 8 == 6) || (B % 8 == 7))){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(C == 31) && (C % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 2) && !(H == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 3)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(C == 31) && (C % 8 == 0) && (H == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 1) && (A == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 2) && (B == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 4) && (D == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 5) && (S == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && ((C % 8 == 6) || (C % 8 == 7))){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}

  else if (!(D == 31) && (D % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(D == 31) && (D % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(D == 31) && (D % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(D == 31) && (D % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(D == 31) && (D % 8 == 4)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(D == 31) && (D % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(D == 31) && (D % 8 == 0) && (H == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(D == 31) && (D % 8 == 1) && (A == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(D == 31) && (D % 8 == 2) && (B == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(D == 31) && (D % 8 == 3) && (C == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(D == 31) && (D % 8 == 5) && (S == 31)){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(D == 31) && ((D % 8 == 6) || (D % 8 == 7))){
    if (!(lastNotV1num == lastNotV2num)){
    IV = recalc(H, A, B, C, D, S, lastNotV1);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  int thirdVcount = 0;
  if (IV[0] == 31)
  thirdVcount++;
  if (IV[1] == 31)
  thirdVcount++;
  if (IV[2] == 31)
  thirdVcount++;
  if (IV[3] == 31)
  thirdVcount++;
  if (IV[4] == 31)
  thirdVcount++;
  if (IV[5] == 31)
  thirdVcount++;

  unknownCount = 0;
  if (IV[0] > 31)
  unknownCount++;
  if (IV[1] > 31)
  unknownCount++;
  if (IV[2] > 31)
  unknownCount++;
  if (IV[3] > 31)
  unknownCount++;
  if (IV[4] > 31)
  unknownCount++;
  if (IV[5] > 31)
  unknownCount++;

  firstNotV = "no select";
  if (!(IV[0] == 31))
  firstNotV = "H";
  else if (!(IV[1] == 31))
  firstNotV = "A";
  else if (!(IV[2] == 31))
  firstNotV = "B";
  else if (!(IV[3] == 31))
  firstNotV = "C";
  else if (!(IV[4] == 31))
  firstNotV = "D";
  else if (!(IV[5] == 31))
  firstNotV = "S";

  int lastNotV3num = 7;
  if (!(IV[5] == 31))
  lastNotV3num = 5;
  else if (!(IV[4] == 31))
  lastNotV3num = 4;
  else if (!(IV[3] == 31))
  lastNotV3num = 3;
  else if (!(IV[2] == 31))
  lastNotV3num = 2;
  else if (!(IV[1] == 31))
  lastNotV3num = 1;
  else if (!(IV[0] == 31))
  lastNotV3num = 0;

  int lastNotV3 = 999;
  if(lastNotV3num == 5)
  lastNotV3 = IV[5];
  else if(lastNotV3num == 4)
  lastNotV3 = IV[4];
  else if(lastNotV3num == 3)
  lastNotV3 = IV[3];
  else if(lastNotV3num == 2)
  lastNotV3 = IV[2];
  else if(lastNotV3num == 1)
  lastNotV3 = IV[1];
  else if(lastNotV3num == 0)
  lastNotV3 = IV[0];

  if ((((firstVcount == 2) && (unknownCount >= 1) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32)))
   || ((firstVcount == 3) && (unknownCount >= 2) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32))
   && ((IV[0] == 33) || (IV[1] == 33) || (IV[2] == 33) || (IV[3] == 33) || (IV[4] == 33) || (IV[5] == 33)))) && (secondVcount < thirdVcount)){
  System.out.println("連続個体値を得られました。");
  for (int f = 0; f < notV.size(); f++){
  System.out.print(notV.get(f) + " ");
}
  if ((IV[0] == 32))
  System.out.print("[" + thirdVcount + "V個体のH] ");
  if ((IV[1] == 32))
  System.out.print("[" + thirdVcount + "V個体のA] ");
  if ((IV[2] == 32))
  System.out.print("[" + thirdVcount + "V個体のB] ");
  if ((IV[3] == 32))
  System.out.print("[" + thirdVcount + "V個体のC] ");
  if ((IV[4] == 32))
  System.out.print("[" + thirdVcount + "V個体のD] ");
  if ((IV[5] == 32))
  System.out.print("[" + thirdVcount + "V個体のS] ");
  if ((IV[0] == 33))
  System.out.print("[" + thirdVcount + "V個体のH] ");
  if ((IV[1] == 33))
  System.out.print("[" + thirdVcount + "V個体のA] ");
  if ((IV[2] == 33))
  System.out.print("[" + thirdVcount + "V個体のB] ");
  if ((IV[3] == 33))
  System.out.print("[" + thirdVcount + "V個体のC] ");
  if ((IV[4] == 33))
  System.out.print("[" + thirdVcount + "V個体のD] ");
  if ((IV[5] == 33))
  System.out.print("[" + thirdVcount + "V個体のS] ");
  System.out.println("の5つの個体値が連続個体値です。");
  Crash();
  System.exit(0);
}else{
  if ((thirdVcount == 5) || (((IV[0] > 32) || (IV[1] > 32) || (IV[2] > 32) || (IV[3] > 32) || (IV[4] > 32) || (IV[5] > 32))
  && (!(IV[0] == 32) && !(IV[1] == 32) && !(IV[2] == 32) && !(IV[3] == 32) && !(IV[4] == 32) && !(IV[5] == 32)))){
  System.out.println("連続個体値を得られませんでした");
  faleCounter();
  System.exit(0);
}
else if (((firstNotV.equals(Hst)) && (IV[0] > 31)) || ((firstNotV.equals(Ast)) && (IV[1] > 31)) || ((firstNotV.equals(Bst)) && (IV[2] > 31)) ||
        ((firstNotV.equals(Cst)) && (IV[3] > 31)) || ((firstNotV.equals(Dst)) && (IV[4] > 31)) || ((firstNotV.equals(Sst)) && (IV[5] > 31))){
System.out.println("再計算回数が多すぎるため、連続個体値が得られているか判定できません");
faleCounter();
System.exit(0);
}else{
  H = IV[0]; A = IV[1]; B = IV[2]; C = IV[3]; D = IV[4]; S = IV[5];
  if (!(H == 31) && (H % 8 == 0)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(H == 31) && (H % 8 == 1) && (A == 31) ){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 2) && (B == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 3) && (C == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 4) && (D == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 5) && (S == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && ((H % 8 == 6) || (H % 8 == 7))){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(A == 31) && (A % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 1)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(A == 31) && (A % 8 == 0) && (H == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 2) && (B == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 3) && (C == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 4) && (D == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 5) && (S == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && ((A % 8 == 6) || (A % 8 == 7))){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(B == 31) && (B % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 2)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(B == 31) && (B % 8 == 0) && (H == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 1) && (A == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 3) && (C == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 4) && (D == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 5) && (S == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && ((B % 8 == 6) || (B % 8 == 7))){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(C == 31) && (C % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 2) && !(H == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 3)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(C == 31) && (C % 8 == 0) && (H == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 1) && (A == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 2) && (B == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 4) && (D == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 5) && (S == 31)){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && ((C % 8 == 6) || (C % 8 == 7))){
    if (!(lastNotV2num == lastNotV3num)){
    IV = recalc(H, A, B, C, D, S, lastNotV2);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


else if (!(D == 31) && (D % 8 == 0) && !(H == 31)){
  H = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 1) && !(A == 31)){
  A = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 2) && !(B == 31)){
  B = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 3) && !(C == 31)){
  C = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 4)){
  D = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 5) && !(S == 31)){
  S = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}

else if (!(D == 31) && (D % 8 == 0) && (H == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 1) && (A == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 2) && (B == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 3) && (C == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 5) && (S == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && ((D % 8 == 6) || (D % 8 == 7))){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}

  int forceVcount = 0;
  if (IV[0] == 31)
  forceVcount++;
  if (IV[1] == 31)
  forceVcount++;
  if (IV[2] == 31)
  forceVcount++;
  if (IV[3] == 31)
  forceVcount++;
  if (IV[4] == 31)
  forceVcount++;
  if (IV[5] == 31)
  forceVcount++;

  unknownCount = 0;
  if (IV[0] > 31)
  unknownCount++;
  if (IV[1] > 31)
  unknownCount++;
  if (IV[2] > 31)
  unknownCount++;
  if (IV[3] > 31)
  unknownCount++;
  if (IV[4] > 31)
  unknownCount++;
  if (IV[5] > 31)
  unknownCount++;

  firstNotV = "no select";
  if (!(IV[0] == 31))
  firstNotV = "H";
  else if (!(IV[1] == 31))
  firstNotV = "A";
  else if (!(IV[2] == 31))
  firstNotV = "B";
  else if (!(IV[3] == 31))
  firstNotV = "C";
  else if (!(IV[4] == 31))
  firstNotV = "D";
  else if (!(IV[5] == 31))
  firstNotV = "S";

  int lastNotV4num = 7;
  if (!(IV[5] == 31))
  lastNotV4num = 5;
  else if (!(IV[4] == 31))
  lastNotV4num = 4;
  else if (!(IV[3] == 31))
  lastNotV4num = 3;
  else if (!(IV[2] == 31))
  lastNotV4num = 2;
  else if (!(IV[1] == 31))
  lastNotV4num = 1;
  else if (!(IV[0] == 31))
  lastNotV4num = 0;

  int lastNotV4 = 999;
  if(lastNotV4num == 5)
  lastNotV4 = IV[5];
  else if(lastNotV4num == 4)
  lastNotV4 = IV[4];
  else if(lastNotV4num == 3)
  lastNotV4 = IV[3];
  else if(lastNotV4num == 2)
  lastNotV4 = IV[2];
  else if(lastNotV4num == 1)
  lastNotV4 = IV[1];
  else if(lastNotV4num == 0)
  lastNotV4 = IV[0];

  if ((((firstVcount == 2) && (unknownCount >= 1) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32)))
   || ((firstVcount == 3) && (unknownCount >= 2) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32))
   && ((IV[0] == 33) || (IV[1] == 33) || (IV[2] == 33) || (IV[3] == 33) || (IV[4] == 33) || (IV[5] == 33)))) && (thirdVcount < forceVcount)){
  System.out.println("連続個体値を得られました。");
  for (int f = 0; f < notV.size(); f++){
  System.out.print(notV.get(f) + " ");
}
  if ((IV[0] == 32))
  System.out.print("[" + forceVcount + "V個体のH] ");
  if ((IV[1] == 32))
  System.out.print("[" + forceVcount + "V個体のA] ");
  if ((IV[2] == 32))
  System.out.print("[" + forceVcount + "V個体のB] ");
  if ((IV[3] == 32))
  System.out.print("[" + forceVcount + "V個体のC] ");
  if ((IV[4] == 32))
  System.out.print("[" + forceVcount + "V個体のD] ");
  if ((IV[5] == 32))
  System.out.print("[" + forceVcount + "V個体のS] ");
  if ((IV[0] == 33))
  System.out.print("[" + forceVcount + "V個体のH] ");
  if ((IV[1] == 33))
  System.out.print("[" + forceVcount + "V個体のA] ");
  if ((IV[2] == 33))
  System.out.print("[" + forceVcount + "V個体のB] ");
  if ((IV[3] == 33))
  System.out.print("[" + forceVcount + "V個体のC] ");
  if ((IV[4] == 33))
  System.out.print("[" + forceVcount + "V個体のD] ");
  if ((IV[5] == 33))
  System.out.print("[" + forceVcount + "V個体のS] ");
  System.out.println("の5つの個体値が連続個体値です。");
  Crash();
  System.exit(0);
}else{
  if ((forceVcount == 5) || (((IV[0] > 32) || (IV[1] > 32) || (IV[2] > 32) || (IV[3] > 32) || (IV[4] > 32) || (IV[5] > 32))
  && (!(IV[0] == 32) && !(IV[1] == 32) && !(IV[2] == 32) && !(IV[3] == 32) && !(IV[4] == 32) && !(IV[5] == 32)))){
  System.out.println("連続個体値を得られませんでした");
  faleCounter();
  System.exit(0);
}
else if (((firstNotV.equals(Hst)) && (IV[0] > 31)) || ((firstNotV.equals(Ast)) && (IV[1] > 31)) || ((firstNotV.equals(Bst)) && (IV[2] > 31)) ||
        ((firstNotV.equals(Cst)) && (IV[3] > 31)) || ((firstNotV.equals(Dst)) && (IV[4] > 31)) || ((firstNotV.equals(Sst)) && (IV[5] > 31))){
System.out.println("再計算回数が多すぎるため、連続個体値が得られているか判定できません");
faleCounter();
System.exit(0);
}else{
  H = IV[0]; A = IV[1]; B = IV[2]; C = IV[3]; D = IV[4]; S = IV[5];
  if (!(H == 31) && (H % 8 == 0)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(H == 31) && (H % 8 == 1) && (A == 31) ){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 2) && (B == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 3) && (C == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && ((H % 8 == 6) || (H % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(A == 31) && (A % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 1)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(A == 31) && (A % 8 == 0) && (H == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 2) && (B == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 3) && (C == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && ((A % 8 == 6) || (A % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(B == 31) && (B % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 2)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(B == 31) && (B % 8 == 0) && (H == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 1) && (A == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 3) && (C == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && ((B % 8 == 6) || (B % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(C == 31) && (C % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 2) && !(H == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 3)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(C == 31) && (C % 8 == 0) && (H == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 1) && (A == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 2) && (B == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && ((C % 8 == 6) || (C % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


else if (!(D == 31) && (D % 8 == 0) && !(H == 31)){
  H = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 1) && !(A == 31)){
  A = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 2) && !(B == 31)){
  B = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 3) && !(C == 31)){
  C = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 4)){
  D = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 5) && !(S == 31)){
  S = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}

else if (!(D == 31) && (D % 8 == 0) && (H == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 1) && (A == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 2) && (B == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 3) && (C == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 5) && (S == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && ((D % 8 == 6) || (D % 8 == 7))){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}


  int fifthVcount = 0;
  if (IV[0] == 31)
  fifthVcount++;
  if (IV[1] == 31)
  fifthVcount++;
  if (IV[2] == 31)
  fifthVcount++;
  if (IV[3] == 31)
  fifthVcount++;
  if (IV[4] == 31)
  fifthVcount++;
  if (IV[5] == 31)
  fifthVcount++;

  unknownCount = 0;
  if (IV[0] > 31)
  unknownCount++;
  if (IV[1] > 31)
  unknownCount++;
  if (IV[2] > 31)
  unknownCount++;
  if (IV[3] > 31)
  unknownCount++;
  if (IV[4] > 31)
  unknownCount++;
  if (IV[5] > 31)
  unknownCount++;

  firstNotV = "no select";
  if (!(IV[0] == 31))
  firstNotV = "H";
  else if (!(IV[1] == 31))
  firstNotV = "A";
  else if (!(IV[2] == 31))
  firstNotV = "B";
  else if (!(IV[3] == 31))
  firstNotV = "C";
  else if (!(IV[4] == 31))
  firstNotV = "D";
  else if (!(IV[5] == 31))
  firstNotV = "S";

  int lastNotV5num = 7;
  if (!(IV[5] == 31))
  lastNotV5num = 5;
  else if (!(IV[4] == 31))
  lastNotV5num = 4;
  else if (!(IV[3] == 31))
  lastNotV5num = 3;
  else if (!(IV[2] == 31))
  lastNotV5num = 2;
  else if (!(IV[1] == 31))
  lastNotV5num = 1;
  else if (!(IV[0] == 31))
  lastNotV5num = 0;

  int lastNotV5 = 999;
  if(lastNotV5num == 5)
  lastNotV5 = IV[5];
  else if(lastNotV5num == 4)
  lastNotV5 = IV[4];
  else if(lastNotV5num == 3)
  lastNotV5 = IV[3];
  else if(lastNotV5num == 2)
  lastNotV5 = IV[2];
  else if(lastNotV5num == 1)
  lastNotV5 = IV[1];
  else if(lastNotV5num == 0)
  lastNotV5 = IV[0];

  if ((((firstVcount == 2) && (unknownCount >= 1) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32)))
   || ((firstVcount == 3) && (unknownCount >= 2) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32))
   && ((IV[0] == 33) || (IV[1] == 33) || (IV[2] == 33) || (IV[3] == 33) || (IV[4] == 33) || (IV[5] == 33)))) && (forceVcount < fifthVcount)){
  System.out.println("連続個体値を得られました。");
  for (int f = 0; f < notV.size(); f++){
  System.out.print(notV.get(f) + " ");
}
  if ((IV[0] == 32))
  System.out.print("[" + fifthVcount + "V個体のH] ");
  if ((IV[1] == 32))
  System.out.print("[" + fifthVcount + "V個体のA] ");
  if ((IV[2] == 32))
  System.out.print("[" + fifthVcount + "V個体のB] ");
  if ((IV[3] == 32))
  System.out.print("[" + fifthVcount + "V個体のC] ");
  if ((IV[4] == 32))
  System.out.print("[" + fifthVcount + "V個体のD] ");
  if ((IV[5] == 32))
  System.out.print("[" + fifthVcount + "V個体のS] ");
  if ((IV[0] == 33))
  System.out.print("[" + fifthVcount + "V個体のH] ");
  if ((IV[1] == 33))
  System.out.print("[" + fifthVcount + "V個体のA] ");
  if ((IV[2] == 33))
  System.out.print("[" + fifthVcount + "V個体のB] ");
  if ((IV[3] == 33))
  System.out.print("[" + fifthVcount + "V個体のC] ");
  if ((IV[4] == 33))
  System.out.print("[" + fifthVcount + "V個体のD] ");
  if ((IV[5] == 33))
  System.out.print("[" + fifthVcount + "V個体のS] ");
  System.out.println("の5つの個体値が連続個体値です。");
  Crash();
  System.exit(0);
}else{
  if ((fifthVcount == 5) || (((IV[0] > 32) || (IV[1] > 32) || (IV[2] > 32) || (IV[3] > 32) || (IV[4] > 32) || (IV[5] > 32))
  && (!(IV[0] == 32) && !(IV[1] == 32) && !(IV[2] == 32) && !(IV[3] == 32) && !(IV[4] == 32) && !(IV[5] == 32)))){
  System.out.println("連続個体値を得られませんでした");
  faleCounter();
  System.exit(0);
}
else if ((((firstNotV.equals(Hst)) && (IV[0] > 31)) || ((firstNotV.equals(Ast)) && (IV[1] > 31)) || ((firstNotV.equals(Bst)) && (IV[2] > 31)) ||
        ((firstNotV.equals(Cst)) && (IV[3] > 31)) || ((firstNotV.equals(Dst)) && (IV[4] > 31)) || ((firstNotV.equals(Sst)) && (IV[5] > 31)))
        || ((IV[0] >= 31) && (IV[1] >= 31) && (IV[2] >= 31) && (IV[3] >= 31) && (IV[4] >= 31) && (IV[5] >= 31))){
System.out.println("再計算回数が多すぎるため、連続個体値が得られているか判定できません");
faleCounter();
System.exit(0);
}else{
  H = IV[0]; A = IV[1]; B = IV[2]; C = IV[3]; D = IV[4]; S = IV[5];
  if (!(H == 31) && (H % 8 == 0)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(H == 31) && (H % 8 == 1) && (A == 31) ){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 2) && (B == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 3) && (C == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && ((H % 8 == 6) || (H % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(A == 31) && (A % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 1)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(A == 31) && (A % 8 == 0) && (H == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 2) && (B == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 3) && (C == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && ((A % 8 == 6) || (A % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(B == 31) && (B % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 2)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(B == 31) && (B % 8 == 0) && (H == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 1) && (A == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 3) && (C == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && ((B % 8 == 6) || (B % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(C == 31) && (C % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 2) && !(H == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 3)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(C == 31) && (C % 8 == 0) && (H == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 1) && (A == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 2) && (B == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && ((C % 8 == 6) || (C % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


else if (!(D == 31) && (D % 8 == 0) && !(H == 31)){
  H = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 1) && !(A == 31)){
  A = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 2) && !(B == 31)){
  B = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 3) && !(C == 31)){
  C = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 4)){
  D = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 5) && !(S == 31)){
  S = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}

else if (!(D == 31) && (D % 8 == 0) && (H == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 1) && (A == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 2) && (B == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 3) && (C == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 5) && (S == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && ((D % 8 == 6) || (D % 8 == 7))){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}


  int sixthVcount = 0;
  if (IV[0] == 31)
  sixthVcount++;
  if (IV[1] == 31)
  sixthVcount++;
  if (IV[2] == 31)
  sixthVcount++;
  if (IV[3] == 31)
  sixthVcount++;
  if (IV[4] == 31)
  sixthVcount++;
  if (IV[5] == 31)
  sixthVcount++;

  unknownCount = 0;
  if (IV[0] > 31)
  unknownCount++;
  if (IV[1] > 31)
  unknownCount++;
  if (IV[2] > 31)
  unknownCount++;
  if (IV[3] > 31)
  unknownCount++;
  if (IV[4] > 31)
  unknownCount++;
  if (IV[5] > 31)
  unknownCount++;

  firstNotV = "no select";
  if (!(IV[0] == 31))
  firstNotV = "H";
  else if (!(IV[1] == 31))
  firstNotV = "A";
  else if (!(IV[2] == 31))
  firstNotV = "B";
  else if (!(IV[3] == 31))
  firstNotV = "C";
  else if (!(IV[4] == 31))
  firstNotV = "D";
  else if (!(IV[5] == 31))
  firstNotV = "S";

  int lastNotV6num = 7;
  if (!(IV[5] == 31))
  lastNotV6num = 5;
  else if (!(IV[4] == 31))
  lastNotV6num = 4;
  else if (!(IV[3] == 31))
  lastNotV6num = 3;
  else if (!(IV[2] == 31))
  lastNotV6num = 2;
  else if (!(IV[1] == 31))
  lastNotV6num = 1;
  else if (!(IV[0] == 31))
  lastNotV6num = 0;

  int lastNotV6 = 999;
  if(lastNotV6num == 5)
  lastNotV6 = IV[5];
  else if(lastNotV6num == 4)
  lastNotV6 = IV[4];
  else if(lastNotV6num == 3)
  lastNotV6 = IV[3];
  else if(lastNotV6num == 2)
  lastNotV6 = IV[2];
  else if(lastNotV6num == 1)
  lastNotV6 = IV[1];
  else if(lastNotV6num == 0)
  lastNotV6 = IV[0];

  if ((((firstVcount == 2) && (unknownCount >= 1) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32)))
   || ((firstVcount == 3) && (unknownCount >= 2) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32))
   && ((IV[0] == 33) || (IV[1] == 33) || (IV[2] == 33) || (IV[3] == 33) || (IV[4] == 33) || (IV[5] == 33)))) && (fifthVcount < sixthVcount)){
  System.out.println("連続個体値を得られました。");
  for (int f = 0; f < notV.size(); f++){
  System.out.print(notV.get(f) + " ");
}
  if ((IV[0] == 32))
  System.out.print("[" + sixthVcount + "V個体のH] ");
  if ((IV[1] == 32))
  System.out.print("[" + sixthVcount + "V個体のA] ");
  if ((IV[2] == 32))
  System.out.print("[" + sixthVcount + "V個体のB] ");
  if ((IV[3] == 32))
  System.out.print("[" + sixthVcount + "V個体のC] ");
  if ((IV[4] == 32))
  System.out.print("[" + sixthVcount + "V個体のD] ");
  if ((IV[5] == 32))
  System.out.print("[" + sixthVcount + "V個体のS] ");
  if ((IV[0] == 33))
  System.out.print("[" + sixthVcount + "V個体のH] ");
  if ((IV[1] == 33))
  System.out.print("[" + sixthVcount + "V個体のA] ");
  if ((IV[2] == 33))
  System.out.print("[" + sixthVcount + "V個体のB] ");
  if ((IV[3] == 33))
  System.out.print("[" + sixthVcount + "V個体のC] ");
  if ((IV[4] == 33))
  System.out.print("[" + sixthVcount + "V個体のD] ");
  if ((IV[5] == 33))
  System.out.print("[" + sixthVcount + "V個体のS] ");
  System.out.println("の5つの個体値が連続個体値です。");
  Crash();
  System.exit(0);
}else{
  if ((sixthVcount == 5) || (((IV[0] > 32) || (IV[1] > 32) || (IV[2] > 32) || (IV[3] > 32) || (IV[4] > 32) || (IV[5] > 32))
  && (!(IV[0] == 32) && !(IV[1] == 32) && !(IV[2] == 32) && !(IV[3] == 32) && !(IV[4] == 32) && !(IV[5] == 32)))){
  System.out.println("連続個体値を得られませんでした");
  faleCounter();
  System.exit(0);
}
else if ((((firstNotV.equals(Hst)) && (IV[0] > 31)) || ((firstNotV.equals(Ast)) && (IV[1] > 31)) || ((firstNotV.equals(Bst)) && (IV[2] > 31)) ||
        ((firstNotV.equals(Cst)) && (IV[3] > 31)) || ((firstNotV.equals(Dst)) && (IV[4] > 31)) || ((firstNotV.equals(Sst)) && (IV[5] > 31)))
        || ((IV[0] >= 31) && (IV[1] >= 31) && (IV[2] >= 31) && (IV[3] >= 31) && (IV[4] >= 31) && (IV[5] >= 31))){
System.out.println("再計算回数が多すぎるため、連続個体値が得られているか判定できません");
faleCounter();
System.exit(0);
}else{
  H = IV[0]; A = IV[1]; B = IV[2]; C = IV[3]; D = IV[4]; S = IV[5];
  if (!(H == 31) && (H % 8 == 0)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(H == 31) && (H % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(H == 31) && (H % 8 == 1) && (A == 31) ){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 2) && (B == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 3) && (C == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && (H % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(H == 31) && ((H % 8 == 6) || (H % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(A == 31) && (A % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 1)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 2) && !(B == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(A == 31) && (A % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(A == 31) && (A % 8 == 0) && (H == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 2) && (B == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 3) && (C == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && (A % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(A == 31) && ((A % 8 == 6) || (A % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(B == 31) && (B % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 2)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 3) && !(C == 31)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(B == 31) && (B % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(B == 31) && (B % 8 == 0) && (H == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 1) && (A == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 3) && (C == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && (B % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(B == 31) && ((B % 8 == 6) || (B % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


  else if (!(C == 31) && (C % 8 == 0) && !(H == 31)){
    H = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 1) && !(A == 31)){
    A = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 2) && !(H == 31)){
    B = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 3)){
    C = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 4) && !(D == 31)){
    D = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }
  else if (!(C == 31) && (C % 8 == 5) && !(S == 31)){
    S = 31;
    IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
  }

  else if (!(C == 31) && (C % 8 == 0) && (H == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 1) && (A == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 2) && (B == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 4) && (D == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && (C % 8 == 5) && (S == 31)){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}
  else if (!(C == 31) && ((C % 8 == 6) || (C % 8 == 7))){
    if (!(lastNotV3num == lastNotV4num)){
    IV = recalc(H, A, B, C, D, S, lastNotV3);
  }else{
    IV = recalc(H, A, B, C, D, S);
  }
}


else if (!(D == 31) && (D % 8 == 0) && !(H == 31)){
  H = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 1) && !(A == 31)){
  A = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 2) && !(B == 31)){
  B = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 3) && !(C == 31)){
  C = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 4)){
  D = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}
else if (!(D == 31) && (D % 8 == 5) && !(S == 31)){
  S = 31;
  IV[0] = H; IV[1] = A; IV[2] = B; IV[3] = C; IV[4] = D; IV[5] = S;
}

else if (!(D == 31) && (D % 8 == 0) && (H == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 1) && (A == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 2) && (B == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 3) && (C == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && (D % 8 == 5) && (S == 31)){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}
else if (!(D == 31) && ((D % 8 == 6) || (D % 8 == 7))){
  if (!(lastNotV1num == lastNotV2num)){
  IV = recalc(H, A, B, C, D, S, lastNotV1);
}else{
  IV = recalc(H, A, B, C, D, S);
}
}


  int seventhVcount = 0;
  if (IV[0] == 31)
  seventhVcount++;
  if (IV[1] == 31)
  seventhVcount++;
  if (IV[2] == 31)
  seventhVcount++;
  if (IV[3] == 31)
  seventhVcount++;
  if (IV[4] == 31)
  seventhVcount++;
  if (IV[5] == 31)
  seventhVcount++;

  unknownCount = 0;
  if (IV[0] > 31)
  unknownCount++;
  if (IV[1] > 31)
  unknownCount++;
  if (IV[2] > 31)
  unknownCount++;
  if (IV[3] > 31)
  unknownCount++;
  if (IV[4] > 31)
  unknownCount++;
  if (IV[5] > 31)
  unknownCount++;

  firstNotV = "no select";
  if (!(IV[0] == 31))
  firstNotV = "H";
  else if (!(IV[1] == 31))
  firstNotV = "A";
  else if (!(IV[2] == 31))
  firstNotV = "B";
  else if (!(IV[3] == 31))
  firstNotV = "C";
  else if (!(IV[4] == 31))
  firstNotV = "D";
  else if (!(IV[5] == 31))
  firstNotV = "S";

  int lastNotV7num = 7;
  if (!(IV[5] == 31))
  lastNotV7num = 5;
  else if (!(IV[4] == 31))
  lastNotV7num = 4;
  else if (!(IV[3] == 31))
  lastNotV7num = 3;
  else if (!(IV[2] == 31))
  lastNotV7num = 2;
  else if (!(IV[1] == 31))
  lastNotV7num = 1;
  else if (!(IV[0] == 31))
  lastNotV7num = 0;

  int lastNotV7 = 999;
  if(lastNotV7num == 5)
  lastNotV7 = IV[5];
  else if(lastNotV7num == 4)
  lastNotV7 = IV[4];
  else if(lastNotV7num == 3)
  lastNotV7 = IV[3];
  else if(lastNotV7num == 2)
  lastNotV7 = IV[2];
  else if(lastNotV7num == 1)
  lastNotV7 = IV[1];
  else if(lastNotV7num == 0)
  lastNotV7 = IV[0];

  if ((((firstVcount == 2) && (unknownCount == 1) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32)))
   || ((firstVcount == 3) && (unknownCount == 2) && ((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32))
   && ((IV[0] == 33) || (IV[1] == 33) || (IV[2] == 33) || (IV[3] == 33) || (IV[4] == 33) || (IV[5] == 33)))) && (sixthVcount < seventhVcount)){
  System.out.println("連続個体値を得られました。");
  for (int f = 0; f < notV.size(); f++){
  System.out.print(notV.get(f) + " ");
}
  if ((IV[0] == 32))
  System.out.print("[" + seventhVcount + "V個体のH] ");
  if ((IV[1] == 32))
  System.out.print("[" + seventhVcount + "V個体のA] ");
  if ((IV[2] == 32))
  System.out.print("[" + seventhVcount + "V個体のB] ");
  if ((IV[3] == 32))
  System.out.print("[" + seventhVcount + "V個体のC] ");
  if ((IV[4] == 32))
  System.out.print("[" + seventhVcount + "V個体のD] ");
  if ((IV[5] == 32))
  System.out.print("[" + seventhVcount + "V個体のS] ");
  if ((IV[0] == 33))
  System.out.print("[" + seventhVcount + "V個体のH] ");
  if ((IV[1] == 33))
  System.out.print("[" + seventhVcount + "V個体のA] ");
  if ((IV[2] == 33))
  System.out.print("[" + seventhVcount + "V個体のB] ");
  if ((IV[3] == 33))
  System.out.print("[" + seventhVcount + "V個体のC] ");
  if ((IV[4] == 33))
  System.out.print("[" + seventhVcount + "V個体のD] ");
  if ((IV[5] == 33))
  System.out.print("[" + seventhVcount + "V個体のS] ");
  System.out.println("の5つの個体値が連続個体値です。");
  Crash();
  System.exit(0);
}else{
  if ((seventhVcount == 5) || (((IV[0] > 32) || (IV[1] > 32) || (IV[2] > 32) || (IV[3] > 32) || (IV[4] > 32) || (IV[5] > 32))
  && (!(IV[0] == 32) && !(IV[1] == 32) && !(IV[2] == 32) && !(IV[3] == 32) && !(IV[4] == 32) && !(IV[5] == 32)))){
  System.out.println("連続個体値を得られませんでした");
  faleCounter();
  System.exit(0);
}
else if ((((firstNotV.equals(Hst)) && (IV[0] > 31)) || ((firstNotV.equals(Ast)) && (IV[1] > 31)) || ((firstNotV.equals(Bst)) && (IV[2] > 31)) ||
        ((firstNotV.equals(Cst)) && (IV[3] > 31)) || ((firstNotV.equals(Dst)) && (IV[4] > 31)) || ((firstNotV.equals(Sst)) && (IV[5] > 31)))
        || ((IV[0] >= 31) && (IV[1] >= 31) && (IV[2] >= 31) && (IV[3] >= 31) && (IV[4] >= 31) && (IV[5] >= 31))){
System.out.println("再計算回数が多すぎるため、連続個体値が得られているか判定できません");
faleCounter();
System.exit(0);
}else{
  System.out.println("なんらかの問題が発生しました。");
  System.exit(0);
}
}
}
}
}
}
}
}
}
}
}
}
}

  public static int[] recalc(int H, int A, int B, int C, int D, int S){
    LinkedList<Integer> num = new LinkedList<Integer>();
    if (!(H == 31))
    num.add(H);
    if (!(A == 31))
    num.add(A);
    if (!(B == 31))
    num.add(B);
    if (!(C == 31))
    num.add(C);
    if (!(D == 31))
    num.add(D);
    if (!(S == 31))
    num.add(S);
    num.remove(0);
  int[] IV = new int[6];
  IV[0] = H;
  IV[1] = A;
  IV[2] = B;
  IV[3] = C;
  IV[4] = D;
  IV[5] = S;
  boolean IVchangeH = false;
  boolean IVchangeA = false;
  boolean IVchangeB = false;
  boolean IVchangeC = false;
  boolean IVchangeD = false;
  boolean IVchangeS = false;
  int correction = 0;
  if (num.size() == 3)
  correction = 1;

    for (int r = 0; r <= num.size() + correction; r++){
    if ( !(IV[0] == 31) && (IVchangeH == false)){
      IV[0] = num.get(0);
      IVchangeH = true;
  }
    else if (!(IV[1] == 31) && (IVchangeA == false)){
      IV[1] = num.get(0);
      IVchangeA = true;
  }
    else if (!(IV[2] == 31) && (IVchangeB == false)){
      IV[2] = num.get(0);
      IVchangeB = true;
  }
    else if (!(IV[3] == 31) && (IVchangeC == false)){
      IV[3] = num.get(0);
      IVchangeC = true;
  }
    else if (!(IV[4] == 31) && (IVchangeD == false)){
      IV[4] = num.get(0);
      IVchangeD = true;
  }
    else if (!(IV[5] == 31) && (IVchangeS == false)){
      IV[5] = num.get(0);
      IVchangeS = true;
  }
  num.remove(0);
  if (num.isEmpty() == true){
    num.clear();
  }
}


  if (!(IV[0] > 31) && !(IV[1] > 31) && !(IV[2] > 31) && !(IV[3] > 31) && !(IV[4] > 31) && !(IV[5] > 31)){
  if (!(IV[5] == 31))
  IV[5] = 32;
  else if (!(IV[4] == 31))
  IV[4] = 32;
  else if (!(IV[3] == 31))
  IV[3] = 32;
  else if (!(IV[2] == 31))
  IV[2] = 32;
  else if (!(IV[1] == 31))
  IV[1] = 32;
  else if (!(IV[0] == 31))
  IV[0] = 32;
}
  else if (((IV[0] == 32) || (IV[1] == 32) || (IV[2] == 32) || (IV[3] == 32) || (IV[4] == 32) || (IV[5] == 32))
  && (!(IV[0] > 32) && !(IV[1] > 32) && !(IV[2] > 32) && !(IV[3] > 32) && !(IV[4] > 32) && !(IV[5] > 32))){
  if (!(IV[5] == 31))
  IV[5] = 33;
  else if (!(IV[4] == 31))
  IV[4] = 33;
  else if (!(IV[3] == 31))
  IV[3] = 33;
  else if (!(IV[2] == 31))
  IV[2] = 33;
  else if (!(IV[1] == 31))
  IV[1] = 33;
  else if (!(IV[0] == 31))
  IV[0] = 33;
}
  else if (((IV[0] == 33) || (IV[1] == 33) || (IV[2] == 33) || (IV[3] == 33) || (IV[4] == 33) || (IV[5] == 33))
  && (!(IV[0] > 33) && !(IV[1] > 33) && !(IV[2] > 33) && !(IV[3] > 33) && !(IV[4] > 33) && !(IV[5] > 33))){
  if (!(IV[5] == 31))
  IV[5] = 34;
  else if (!(IV[4] == 31))
  IV[4] = 34;
  else if (!(IV[3] == 31))
  IV[3] = 34;
  else if (!(IV[2] == 31))
  IV[2] = 34;
  else if (!(IV[1] == 31))
  IV[1] = 34;
  else if (!(IV[0] == 31))
  IV[0] = 34;
}
  else if (((IV[0] == 34) || (IV[1] == 34) || (IV[2] == 34) || (IV[3] == 34) || (IV[4] == 34) || (IV[5] == 34))
  && (!(IV[0] > 34) && !(IV[1] > 34) && !(IV[2] > 34) && !(IV[3] > 34) && !(IV[4] > 34) && !(IV[5] > 34))){
  if (!(IV[5] == 31))
  IV[5] = 35;
  else if (!(IV[4] == 31))
  IV[4] = 35;
  else if (!(IV[3] == 31))
  IV[3] = 35;
  else if (!(IV[2] == 31))
  IV[2] = 35;
  else if (!(IV[1] == 31))
  IV[1] = 35;
  else if (!(IV[0] == 31))
  IV[0] = 35;
}
    return IV;
  }



  public static int[] recalc(int H, int A, int B, int C, int D, int S, int lastNotV){
    LinkedList<Integer> num = new LinkedList<Integer>();
    if (!(H == 31))
    num.add(H);
    if (!(A == 31))
    num.add(A);
    if (!(B == 31))
    num.add(B);
    if (!(C == 31))
    num.add(C);
    if (!(D == 31))
    num.add(D);
    if (!(S == 31))
    num.add(S);
    num.remove(0);
  int[] IV = new int[6];
  IV[0] = H;
  IV[1] = A;
  IV[2] = B;
  IV[3] = C;
  IV[4] = D;
  IV[5] = S;
  boolean IVchangeH = false;
  boolean IVchangeA = false;
  boolean IVchangeB = false;
  boolean IVchangeC = false;
  boolean IVchangeD = false;
  boolean IVchangeS = false;
  int correction = 0;
  if (num.size() == 3)
  correction = 1;

    for (int r = 0; r <= num.size() + correction; r++){
    if ( !(IV[0] == 31) && (IVchangeH == false)){
      IV[0] = num.get(0);
      IVchangeH = true;
  }
    else if (!(IV[1] == 31) && (IVchangeA == false)){
      IV[1] = num.get(0);
      IVchangeA = true;
  }
    else if (!(IV[2] == 31) && (IVchangeB == false)){
      IV[2] = num.get(0);
      IVchangeB = true;
  }
    else if (!(IV[3] == 31) && (IVchangeC == false)){
      IV[3] = num.get(0);
      IVchangeC = true;
  }
    else if (!(IV[4] == 31) && (IVchangeD == false)){
      IV[4] = num.get(0);
      IVchangeD = true;
  }
    else if (!(IV[5] == 31) && (IVchangeS == false)){
      IV[5] = num.get(0);
      IVchangeS = true;
  }
  num.remove(0);
  if (num.isEmpty() == true){
    num.clear();
  }
}

    if (!(IV[5] == 31))
    IV[5] = lastNotV;
    else if (!(IV[4] == 31))
    IV[4] = lastNotV;
    else if (!(IV[3] == 31))
    IV[3] = lastNotV;
    else if (!(IV[2] == 31))
    IV[2] = lastNotV;
    else if (!(IV[1] == 31))
    IV[1] = lastNotV;
    else if (!(IV[0] == 31))
    IV[0] = lastNotV;


  return IV;
}

public static void faleCounter() {
  try{
    File file = new File("FaleCount.txt");
    file.createNewFile();
    BufferedReader br = new BufferedReader(new FileReader(file));
  
    String str = br.readLine();
    if (str == null){
      str = "0";
    }
      int count = Integer.parseInt(str);
    int faleCount = count + 1;
    System.out.println("失敗回数:" + faleCount);
    System.out.print("");
      Write(faleCount);
      br.close();
  }catch(FileNotFoundException e){
    System.out.println(e);
  }catch(IOException e){
    System.out.println(e);
      }
    }

    	
	public static void Write (int faleCount) {
    try{
	File file = new File("FaleCount.txt");
	file.delete();
	file.createNewFile();
	PrintWriter pw = new PrintWriter(new FileWriter(file));
	String StringFale = String.valueOf(faleCount);
	pw.write(StringFale);
	pw.flush();
  pw.close();
    }catch(FileNotFoundException e){
      System.out.println(e);
    }catch(IOException e){
      System.out.println(e);
        }
	}

	public static void Crash() {
		File file = new File("FaleCount.txt");
		file.delete();
    }
}