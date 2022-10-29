package de.hbrs.ia.model.command;

import de.hbrs.ia.model.exception.ContainerException;

import java.text.ParseException;

public interface Command {

    public void execute() throws ContainerException, ParseException;

    void undo();
}
