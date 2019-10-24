package br.pro.hashi.ensino.desagil.aps.model;

public class XorGate extends Gate{

    private final NandGate nandTop;
    private final NandGate nandBottom;
    private final NandGate nandRight;
    private final NandGate nandLeft;


    public XorGate() {
        super(2);

        nandTop = new NandGate();
        nandBottom = new NandGate();
        nandRight = new NandGate();
        nandLeft = new NandGate();

        nandRight.connect(0, nandTop);
        nandRight.connect(1, nandBottom);

        nandTop.connect(1, nandLeft);
        nandBottom.connect(0, nandLeft);
    }


    @Override
    public boolean read(int outputPin) {
        if (outputPin != 0) {
            throw new IndexOutOfBoundsException(outputPin);
        }
        return nandRight.read();
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        switch (inputPin){
            case 0:
                nandLeft.connect(0, emitter);
                nandTop.connect(0, emitter);
                break;

            case 1:
                nandLeft.connect(1, emitter);
                nandBottom.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputPin);

        }

    }

}
