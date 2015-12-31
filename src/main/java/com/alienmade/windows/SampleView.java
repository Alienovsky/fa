package com.alienmade.windows;

//package sample

/*        import com.googlecode.lanterna.gui.Component
        import com.googlecode.lanterna.gui.Window
        import org.codehaus.griffon.runtime.core.AbstractGriffonView*/

class SampleView {// extends AbstractGriffonView {
/*    FactoryBuilderSupport builder

    void mvcGroupInit(final Map<String, Object> args) {
        execInsideUISync {
            Window window = new Window('Griffon + Lanterna + JPA')
            window.addComponent(init())
            app.windowManager.attach('mainWindow', window)
        }
    }

    void clearTable() {
        builder.peopleTable.removeAllRows()
        List columns = builder.list {
            label('Id')
            label('Name')
            label('Lastname')
        }
        builder.peopleTable.addRow(* columns)
    }

    void addPersonRow(Person person) {
        List components = builder.list {
            button(person.id.toString()) { println model.people.find { it.id == person.id } }
            label(person.name)
            label(person.lastname)
        }
        builder.peopleTable.addRow(* components)
    }

    private Component init() {
        builder.vbox {
            hbox {
                button(loadAction)
                button(clearAction)
            }
            table('People', id: 'peopleTable', cols: 3) {
                label('Id')
                label('Name')
                label('Lastname')
            }
        }
    }*/
}