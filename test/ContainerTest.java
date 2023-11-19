import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerTest {

    private TankContainer tankContainer;
    private DryContainer dryContainer;
    private RefeerContainer refeerContainer;


    @BeforeEach
    void setUp() {
        tankContainer = new TankContainer(10.0, 15.0,20.0,25.3);
        dryContainer = new DryContainer(7.0, 20.1,5.0,29.3);
        refeerContainer = new RefeerContainer(10.5, 1.0,44.5,5.9, 50.5);
    }

    @Test
    void tankContainerOk(){
        assertEquals(10.0,tankContainer.getWidth());
        assertEquals(15.0,tankContainer.getLength());
        assertEquals(20.0,tankContainer.getHeigth());
        assertEquals(25.3,tankContainer.getWeigth());
        assertEquals(3000.0, tankContainer.getVolume());
    }

    @Test
    void dryContainerOk(){
        assertEquals(7.0,dryContainer.getWidth());
        assertEquals(20.1,dryContainer.getLength());
        assertEquals(5.0,dryContainer.getHeigth());
        assertEquals(29.3,dryContainer.getWeigth());
        assertEquals(703.5, dryContainer.getVolume());
    }

    @Test
    void refeerContainerOk(){
        assertEquals(10.5,refeerContainer.getWidth());
        assertEquals(1.0,refeerContainer.getLength());
        assertEquals(44.5,refeerContainer.getHeigth());
        assertEquals(5.9,refeerContainer.getWeigth());
        assertEquals(50.5,refeerContainer.getConsumePerHour());
        assertEquals(467,25, refeerContainer.getVolume());
    }
}
