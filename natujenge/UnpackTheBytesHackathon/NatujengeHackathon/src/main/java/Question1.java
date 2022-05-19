public class Question1 {
    public static void main(String[] args) {
        byte [] byteArray=new byte[]{
                0x13,0x55, (byte) 0xb6,0x76,
                0x79, (byte) 0x88,0x29,0x5e,
                0x00,0x00,0x00,0x00,
                0x00,0x03,0x00,0x34,
                0x7e,0x58,0x1e,0x36,
                0x00,0x00,0x00,0x00,
                0x00,0x00,0x00,0x00
        };
//Common SCTP Header:
        int sourcePort=0;
        sourcePort|=(byteArray[0]&0xff)<<8;
        sourcePort|=(byteArray[1]&0xff);
        System.out.println("source port: "+sourcePort);

        int destinationPort=0;
        destinationPort|=(byteArray[2]&0xff)<<8;
        destinationPort|=(byteArray[3]&0xff);
        System.out.println("destination  port: "+destinationPort);

        int verificationTag=0;
        verificationTag|=((byteArray[4]&0xff)<<24);
        verificationTag|=((byteArray[5]&0xff)<<16);
        verificationTag|=((byteArray[6]&0xff)<<8);
        verificationTag|=(byteArray[7]&0xff);

        long vTag = Integer.toUnsignedLong(verificationTag);
        System.out.println("Verification tag: "+vTag);

        //Data Chunck
        int type=byteArray[12]&0xff;
        System.out.println("type :"+type);

        //flags
        boolean flagB=((byteArray[13]&0xff)&0b00000010)>0;
        System.out.println("B flag: "+flagB);

        int length=0;
        length|=(byteArray[14]&0xff)<<8;
        length|=(byteArray[15]&0xff);
        System.out.println("Length : "+length);
    }
}
