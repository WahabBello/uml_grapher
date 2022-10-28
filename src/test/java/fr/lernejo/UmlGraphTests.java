package fr.lernejo;

import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.UmlGraph;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UmlGraphTests {
    @Test
    void empty_interface_with_no_relation() {
        UmlGraph graph = new UmlGraph(Machin.class);

        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
                classDiagram
                class Machin {
                    <<interface>>
                }
                """);
    }

    @Test
    void interface_with_relation() {
        Class<?>[] classes = { UmlGraphTests.Living.Animal.Cat.class, UmlGraphTests.Living.Animal.Ant.class,
                UmlGraphTests.Living.Plant.Tree.Alder.class };
        UmlGraph graph = new UmlGraph(classes);
        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
                classDiagram
                class Alder
                class Animal {
                    <<interface>>
                }
                class Ant
                class Cat
                class Living {
                    <<interface>>
                }
                class Plant {
                    <<interface>>
                }
                class Tree {
                    <<interface>>
                }
                Tree <|.. Alder : implements
                Living <|-- Animal : extends
                Animal <|.. Ant : implements
                Animal <|.. Cat : implements
                Living <|-- Plant : extends
                Plant <|-- Tree : extends
                """);
    }

    interface Machin {
    }

    public sealed interface Living {
        sealed interface Animal extends Living {
            final class Ant implements Animal {
            }

            final class Cat implements Animal {
            }
        }

        sealed interface Plant extends Living {
            sealed interface Tree extends Plant {
                final class Alder implements Tree {
                }
            }
        }
    }

    public sealed interface Image {

        void display();
    
        final class RealImage implements Image {
    
            private final String fileName;
    
            public RealImage(String fileName){
                this.fileName = fileName;
                loadFromDisk(fileName);
            }
    
            @Override
            public void display() {
                System.out.println("Displaying " + fileName);
            }
    
            private void loadFromDisk(String fileName){
                System.out.println("Loading " + fileName);
            }
        }
    
        final class LazyLoadedImage implements Image{
    
            private RealImage realImage;
            private final String fileName;
    
            public LazyLoadedImage(String fileName){
                this.fileName = fileName;
            }
    
            @Override
            public void display() {
                if(realImage == null){
                    realImage = new RealImage(fileName);
                }
                realImage.display();
            }
        }
    }
    
}
