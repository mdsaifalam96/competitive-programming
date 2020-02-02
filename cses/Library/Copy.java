static class Numbers{static long[]factorials;private final long M;private HashMap<Long,Long>fibHash=new HashMap<>();public Numbers(long m){M=m;}    static long c(int k,int n){return factorials[n]*Numbers.modInverse(factorials[k]*factorials[n-k],MODULO)%MODULO;}    static long _modInverse(long a,long b){long t,q,x0=0,x1=1;if(b==1)return 1;while(a>1){q=a/b;t=b;b=a%b;a=t;t=x0;x0=x1-q*x0;x1=t;}        return x1;}    static long modInverse(long a,long b){long result=_modInverse(a,b);return result<0?result+b:result;}    static long[]generateFactorials(int n,long m){long[]factorial=new long[n+1];factorial[0]=1;factorial[1]=1;for(int i=2;i<=n;i++)factorial[i]=factorial[i-1]*i%m;return factorial;}    long[][]mpow(long[][]a,long k){int s=a.length;long[][]result=new long[s][s];for(int i=0;i<s;i++)result[i][i]=1;while(k>0){if(k%2==1)result=mmul(result,a);a=mmul(a,a);k/=2;}        return result;}    long[][]mmul(long[][]a,long[][]b){int n=a.length,m=b[0].length,pa=a[0].length,pb=b.length;if(pa!=pb)        throw new RuntimeException(String.format("Wrong matrix dimensions %dx%d * %dx%d",n,pa,pb,m));long[][]c=new long[n][m];for(int i=0;i<n;++i){for(int j=0;j<pa;++j){for(int k=0;k<m;++k){c[i][j]=(c[i][j]+(a[i][k]*b[k][j])%MODULO)%MODULO;}}}        return c;}    long fastFib(long n){if(n<0)return 0;if(n<2)return 1;if(fibHash.containsKey(n))return fibHash.get(n);long k=n/2;if(n%2==0){fibHash.put(n,(fastFib(k)*fastFib(k)+fastFib(k-1)*fastFib(k-1))%M);}else{fibHash.put(n,(fastFib(k)*fastFib(k+1)+fastFib(k-1)*fastFib(k))%M);}        return fibHash.get(n);}}
static class FastWriter{private final StringBuilder out;public FastWriter(){out=new StringBuilder(Solution.IO_BUFFERS);}    public FastWriter print(Object object){out.append(object);return this;}    public FastWriter print(String format,Object...args){out.append(String.format(format,args));return this;}    public FastWriter println(Object object){out.append(object).append("\n");return this;}    public void close()throws IOException{System.out.print(out);}}
static class FastReader{private DataInputStream din;private byte[]buffer;private int bufferPointer,bytesRead;public FastReader(){din=new DataInputStream(System.in);buffer=new byte[Solution.IO_BUFFERS];bufferPointer=bytesRead=0;}    public FastReader(String file_name)throws IOException{din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[Solution.IO_BUFFERS];bufferPointer=bytesRead=0;}    public String readLine()throws IOException{StringBuilder sb=new StringBuilder();int c;while((c=read())!=-1){if(c=='\n'){if(sb.length()>0)break;else continue;}        sb.append((char)c);}        return sb.toString();}    public int nextInt()throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return-ret;return ret;}    public long nextLong()throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return-ret;return ret;}    public double nextDouble()throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.'){while((c=read())>='0'&&c<='9'){ret+=(c-'0')/(div*=10);}}        if(neg)return-ret;return ret;}    private void fillBuffer()throws IOException{bytesRead=din.read(buffer,bufferPointer=0,Solution.IO_BUFFERS);if(bytesRead==-1)buffer[0]=-1;}    private byte read()throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];}    public void close()throws IOException{if(din==null)return;din.close();}    int[]fillIntegerArray(int n)throws IOException{int[]array=new int[n];for(int i=0;i<n;i++)array[i]=nextInt();return array;}    long[]fillLongArray(int n)throws IOException{long[]array=new long[n];for(int i=0;i<n;i++)array[i]=nextLong();return array;}}