package br.pro.hashi.ensino.desagil.aps.model;

public class TripleInputAndGate extends Gate {
    private final NandGate nandLeft;
    private final NandGate nandMiddleR;
    private final NandGate nandRight;

    public TripleInputAndGate() {
        super("TripleInputAND", 3);

        nandLeft = new NandGate();
        NandGate nandMiddleL = new NandGate();
        nandMiddleR = new NandGate();
        nandRight = new NandGate();


        nandRight.connect(0, nandMiddleR);
        nandRight.connect(1, nandMiddleR);

        nandMiddleR.connect(0, nandMiddleL);

        nandMiddleL.connect(0, nandLeft);
        nandMiddleL.connect(1, nandLeft);

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
        switch (inputPin) {
            case 0:
                nandLeft.connect(0, emitter);
                break;
            case 1:
                nandLeft.connect(1, emitter);
                break;
            case 2:
                nandMiddleR.connect(1, emitter);
                break;

            default:
                throw new IndexOutOfBoundsException();
        }
    }

}
