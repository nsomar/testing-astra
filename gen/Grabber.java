/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.acre.*;
import astra.cartago.*;
import astra.core.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.eis.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.util.*;

public class Grabber extends ASTRAClass {
	public Grabber() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args")
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Grabber", new int[] {16,25,25,3},
				new Statement[] {
					new ModuleCall("ei",
						"Grabber", new int[] {17,4,17,46},
						new Predicate("launch", new Term[] {
							Primitive.newPrimitive("towerenv"),
							Primitive.newPrimitive("towerenvAstra.jar")
						}),
						new ModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EISAPI) intention.getModule("Grabber","ei")).launch(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Grabber", new int[] {18,4,18,23},
						new Predicate("join", new Term[] {
							Primitive.newPrimitive("towerenv")
						}),
						new ModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EISAPI) intention.getModule("Grabber","ei")).join(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Grabber", new int[] {19,4,19,22},
						new Predicate("link", new Term[] {
							Primitive.newPrimitive("gripper")
						}),
						new ModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EISAPI) intention.getModule("Grabber","ei")).link(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Grabber", new int[] {20,4,20,17},
						new Predicate("startEnv", new Term[] {}),
						new ModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EISAPI) intention.getModule("Grabber","ei")).startEnv(
								);
							}
						}
					),
					new BeliefUpdate('+',
						"Grabber", new int[] {22,4,25,3},
						new Predicate("blocks", new Term[] {
							new ListTerm(new Term[] {

							})
						})
					)
				}
			)
		));
		addRule(new Rule(
			new EISEvent(EISEvent.ADDED,
				Primitive.newPrimitive("towerenv"),
				Primitive.newPrimitive("gripper"),
				new Predicate("block", new Term[] {
					new Variable(Type.STRING, "Name")
				})
			),
			Predicate.TRUE,
			new Block(
				"Grabber", new int[] {27,56,37,3},
				new Statement[] {
					new SynchronizedBlock(
						"Grabber", new int[] {28,6,37,3},
						"tower",
						new Block(
							"Grabber", new int[] {28,6,37,3},
							new Statement[] {
								new Query(
									"Grabber", new int[] {29,10,29,33},
									new Predicate("blocks", new Term[] {
										new Variable(Type.LIST, "Arr")
									})
								),
								new Declaration(
									new Variable(Type.LIST, "New"),
									"Grabber", new int[] {30,10,36,7},
									Operator.newOperator('+',
										new Variable(Type.LIST, "Arr"),
										new ListTerm(new Term[] {
											new Variable(Type.STRING, "Name")
										})
									)
								),
								new BeliefUpdate('-',
									"Grabber", new int[] {32,8,36,7},
									new Predicate("blocks", new Term[] {
										new Variable(Type.LIST, "Arr")
									})
								),
								new BeliefUpdate('+',
									"Grabber", new int[] {33,10,36,7},
									new Predicate("blocks", new Term[] {
										new Variable(Type.LIST, "New")
									})
								),
								new ModuleCall("C",
									"Grabber", new int[] {35,10,35,24},
									new Predicate("println", new Term[] {
										new Variable(Type.LIST, "New")
									}),
									new ModuleCallAdaptor() {
										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Grabber","C")).println(
												(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("solve", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Grabber", new int[] {39,17,46,3},
				new Statement[] {
					new While(
						"Grabber", new int[] {40,6,46,3},
						Predicate.TRUE,
						new Block(
							"Grabber", new int[] {40,17,45,5},
							new Statement[] {
								new Query(
									"Grabber", new int[] {41,10,41,33},
									new Predicate("blocks", new Term[] {
										new Variable(Type.LIST, "Arr")
									})
								),
								new Subgoal(
									"Grabber", new int[] {42,8,45,5},
									new Goal(
										new Predicate("shuffle", new Term[] {
											new Variable(Type.LIST, "Arr"),
											new ModuleTerm("prelude", Type.INTEGER,
												new Predicate("size", new Term[] {
													new Variable(Type.LIST, "Arr")
												}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Prelude) intention.getModule("Grabber","prelude")).size(
															(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.Prelude) visitor.agent().getModule("Grabber","prelude")).size(
															(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										})
									)
								),
								new ModuleCall("C",
									"Grabber", new int[] {43,8,43,22},
									new Predicate("println", new Term[] {
										new Variable(Type.LIST, "Arr")
									}),
									new ModuleCallAdaptor() {
										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Grabber","C")).println(
												(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Grabber", new int[] {44,8,45,5},
									new Goal(
										new Predicate("solveArr", new Term[] {
											new Variable(Type.LIST, "Arr")
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("solveArr", new Term[] {
						new ListSplitter(
							new Variable(Type.STRING, "Head"),
							new Variable(Type.LIST, "Tail")
						)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Grabber", new int[] {48,44,53,3},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "OtherHead"),
						"Grabber", new int[] {49,6,53,3},
						new ModuleTerm("prelude", Type.STRING,
							new Predicate("headAsString", new Term[] {
								new Variable(Type.LIST, "Tail")
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.Prelude) intention.getModule("Grabber","prelude")).headAsString(
										(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.Prelude) visitor.agent().getModule("Grabber","prelude")).headAsString(
										(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
									);
								}
							}
						)
					),
					new Subgoal(
						"Grabber", new int[] {50,6,53,3},
						new Goal(
							new Predicate("grab", new Term[] {
								new Variable(Type.STRING, "OtherHead")
							})
						)
					),
					new Subgoal(
						"Grabber", new int[] {51,6,53,3},
						new Goal(
							new Predicate("putdown", new Term[] {
								new Variable(Type.STRING, "Head")
							})
						)
					),
					new Subgoal(
						"Grabber", new int[] {52,6,53,3},
						new Goal(
							new Predicate("solveArr", new Term[] {
								new Variable(Type.LIST, "Tail")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("solveArr", new Term[] {
						new ListTerm(new Term[] {

						})
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Grabber", new int[] {55,22,57,3},
				new Statement[] {
					new ModuleCall("C",
						"Grabber", new int[] {56,6,56,22},
						new Predicate("print", new Term[] {
							Primitive.newPrimitive("Empty")
						}),
						new ModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Grabber","C")).print(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("shuffle", new Term[] {
						new Variable(Type.LIST, "in"),
						new Variable(Type.INTEGER, "N")
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Grabber", new int[] {59,32,67,3},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"Grabber", new int[] {60,5,67,3},
						Primitive.newPrimitive(0)
					),
					new While(
						"Grabber", new int[] {61,6,67,3},
						new Comparison("<",
							new Variable(Type.INTEGER, "i"),
							new Variable(Type.INTEGER, "N")
						),
						new Block(
							"Grabber", new int[] {61,20,66,7},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "j"),
									"Grabber", new int[] {62,10,66,7},
									Operator.newOperator('%',
										new ModuleTerm("math", Type.INTEGER,
											new Predicate("randomInt", new Term[] {}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.Math) intention.getModule("Grabber","math")).randomInt(
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Math) visitor.agent().getModule("Grabber","math")).randomInt(
													);
												}
											}
										),
										new ModuleTerm("prelude", Type.INTEGER,
											new Predicate("size", new Term[] {
												new Variable(Type.LIST, "in")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.Prelude) intention.getModule("Grabber","prelude")).size(
														(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Prelude) visitor.agent().getModule("Grabber","prelude")).size(
														(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										)
									)
								),
								new Declaration(
									new Variable(Type.INTEGER, "k"),
									"Grabber", new int[] {63,10,66,7},
									Operator.newOperator('%',
										new ModuleTerm("math", Type.INTEGER,
											new Predicate("randomInt", new Term[] {}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.Math) intention.getModule("Grabber","math")).randomInt(
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Math) visitor.agent().getModule("Grabber","math")).randomInt(
													);
												}
											}
										),
										new ModuleTerm("prelude", Type.INTEGER,
											new Predicate("size", new Term[] {
												new Variable(Type.LIST, "in")
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.Prelude) intention.getModule("Grabber","prelude")).size(
														(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Prelude) visitor.agent().getModule("Grabber","prelude")).size(
														(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										)
									)
								),
								new ModuleCall("prelude",
									"Grabber", new int[] {64,10,64,32},
									new Predicate("swap", new Term[] {
										new Variable(Type.LIST, "in"),
										new Variable(Type.INTEGER, "j"),
										new Variable(Type.INTEGER, "k")
									}),
									new ModuleCallAdaptor() {
										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Prelude) intention.getModule("Grabber","prelude")).swap(
												(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
												(java.lang.Integer) intention.evaluate(predicate.getTerm(1)),
												(java.lang.Integer) intention.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new Assignment(
									new Variable(Type.INTEGER, "i"),
									"Grabber", new int[] {65,10,66,7},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "i"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("grabAnyOne", new Term[] {})
				)
			),
			new AND(
				new EISFormula(
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "X"),
						Primitive.newPrimitive("table")
					})
				),
				new NOT(
					new EISFormula(
						new Predicate("on", new Term[] {
							new Variable(Type.STRING, "Anything"),
							new Variable(Type.STRING, "X")
						})
					)
				)
			),
			new Block(
				"Grabber", new int[] {69,79,71,3},
				new Statement[] {
					new Subgoal(
						"Grabber", new int[] {70,6,71,3},
						new Goal(
							new Predicate("grab", new Term[] {
								new Variable(Type.STRING, "X")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("grabAnyOne", new Term[] {})
				)
			),
			new AND(
				new EISFormula(
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "X"),
						new Variable(Type.STRING, "Y")
					})
				),
				new NOT(
					new EISFormula(
						new Predicate("on", new Term[] {
							new Variable(Type.STRING, "Anything"),
							new Variable(Type.STRING, "X")
						})
					)
				)
			),
			new Block(
				"Grabber", new int[] {73,80,75,3},
				new Statement[] {
					new Subgoal(
						"Grabber", new int[] {74,6,75,3},
						new Goal(
							new Predicate("grab", new Term[] {
								new Variable(Type.STRING, "X")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("grab", new Term[] {
						new Variable(Type.STRING, "X")
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Grabber", new int[] {77,24,80,3},
				new Statement[] {
					new EISCall(
						"Grabber", new int[] {78,4,80,3},
						new Predicate("pickup", new Term[] {
							new Variable(Type.STRING, "X")
						})
					),
					new Wait(
						"Grabber", new int[] {79,4,80,3},
						new EISFormula(
							new Predicate("holding", new Term[] {
								new Variable(Type.STRING, "X")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("putdownAnywhere", new Term[] {})
				)
			),
			new AND(
				new EISFormula(
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "X"),
						new Variable(Type.STRING, "Y")
					})
				),
				new NOT(
					new EISFormula(
						new Predicate("on", new Term[] {
							new Variable(Type.STRING, "Anything"),
							new Variable(Type.STRING, "X")
						})
					)
				)
			),
			new Block(
				"Grabber", new int[] {82,85,84,3},
				new Statement[] {
					new Subgoal(
						"Grabber", new int[] {83,4,84,3},
						new Goal(
							new Predicate("putdown", new Term[] {
								new Variable(Type.STRING, "X")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("putdown", new Term[] {
						new Variable(Type.STRING, "Y")
					})
				)
			),
			new EISFormula(
				new Predicate("holding", new Term[] {
					new Variable(Type.STRING, "X")
				})
			),
			new Block(
				"Grabber", new int[] {86,50,89,3},
				new Statement[] {
					new EISCall(
						"Grabber", new int[] {87,4,89,3},
						new Predicate("putdown", new Term[] {
							new Variable(Type.STRING, "X"),
							new Variable(Type.STRING, "Y")
						})
					),
					new Wait(
						"Grabber", new int[] {88,4,89,3},
						new NOT(
							new EISFormula(
								new Predicate("holding", new Term[] {
									new Variable(Type.STRING, "X")
								})
							)
						)
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.addSensorAdaptor(new SensorAdaptor() {
			public void sense(astra.core.Agent agent) {
				((astra.lang.EISAPI) agent.getModule("Grabber","ei")).sense();
			}
		});

	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("C",astra.lang.Console.class,agent);
		fragment.addModule("ei",astra.lang.EISAPI.class,agent);
		fragment.addModule("math",astra.lang.Math.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("prelude",astra.lang.Prelude.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new Grabber().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
