import java.util.*;class M{public static void main(String[]a){int[]d=new int[144];int i=0;Scanner s=new Scanner(System.in).useDelimiter(",");while(s.hasNext()){d[i++]=s.next().equals("X")?1:0;}int[]b={999};for(i=0;i<144;i++){int[]r=new int[145];z(d,i,r);if(r[0]>0&&r[0]<b[0]){b=r;}}String x;if(b[0]<999){x=b[0]+" => ";Arrays.sort(b,1,1+b[0]);int f=0;for(i=1;i<=b[0];i++){if(f==0){f=1;}else{x+=", ";}x+="("+b[i]%12+", "+b[i]/12+")";}System.out.println(x);}}static void z(int[]d,int i,int[]r){if (i<144&&d[i]==1){r[++r[0]]=i;d[i]=0;if((i+1)%12!=0){z(d,i+1,r);z(d,i+13,r);}if(i%12!=0) {z(d,i+11,r);}z(d,i+12,r);}}}