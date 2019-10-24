package br.pro.hashi.ensino.desagil.aps.model;

public class AndGate extends Gate{
    private final NandGate nandRight;
    private final NandGate nandLeft;

    public AndGate(){
        super(2);

        nandLeft = new NandGate();
        nandRight = new NandGate();

        nandRight.connect(0,nandLeft);
        nandRight.connect(1,nandLeft);
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter){
        if(inputPin<0 || inputPin > 1){
            throw new IndexOutOfBoundsException();
        }
        nandLeft.connect(inputPin, emitter);
    }

    @Override
    public boolean read(int outputPin) {
        if(outputPin != 0){
            throw new IndexOutOfBoundsException();

        }
        return nandRight.read();
    }
}
