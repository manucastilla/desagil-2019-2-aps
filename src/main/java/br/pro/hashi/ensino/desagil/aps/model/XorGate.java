package br.pro.hashi.ensino.desagil.aps.model;

public class XorGate {
    private final NandGate nandRight;
    private final NandGate nandLeft;
    private final NandGate nandTop;
    private final NandGate nandBottom;

    public XorGate() {
        super(2);
        nandRight = new NandGate();
        nandLeft = new NandGate();
        nandBottom = new NandGate();
        nandTop = new NandGate();

        nandRight.connect(0, nandTop);
        nandRight.connect(1, nandBottom);
        nandBottom.connect(0, nandLeft);
        nandTop.connect(1, nandLeft);
    }

    @Override
    public boolean read() {
        return nandRight.read();
    }

    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        if (inputPin < 0 || inputPin > 1) {
            throw new IndexOutOfBoundsException(inputPin);
        }
        if (inputPin == 0) {
            nandLeft.connect(0, emitter);
            nandTop.connect(0, emitter);
        }
        if (inputPin == 1) {
            nandLeft.connect(1, emitter);
            nandBottom.connect(1, emitter);
        }
    }

}
