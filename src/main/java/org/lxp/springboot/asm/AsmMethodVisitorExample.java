//package org.lxp.springboot.asm;
//
//import jdk.internal.org.objectweb.asm.ClassReader;
//import jdk.internal.org.objectweb.asm.ClassVisitor;
//import jdk.internal.org.objectweb.asm.MethodVisitor;
//
///**
// * Created by linxiaopeng on 2018-7-23.
// */
//public class AsmMethodVisitorExample {
//
//    public void examle1() throws Exception{
//        new ClassReader(AsmTestBean.class.getName()).accept(new ClassVisitor() {
//            public MethodVisitor visitMethod(int access, String name, String desc,
//                                             String signature, String[] exceptions) {
//                if(name.equals("showlimit") { // We found a method named 'compareTo'
//                    return new MethodVisitor() {
//                        @Override // Callback for byte code method instructions
//                        public void visitMethodInsn(int opcode, String owner,
//                                                    String name, String desc) {
//                            System.out.println("Method " + name + " was called on " + owner);
//                        }
//                        @Override // Callback for byte code field instructions
//                        public void visitFieldInsn(int opcode, String owner,
//                                                   String name, String desc) {
//                            System.out.println("Field " + name + " was accessed on " + owner);
//                        }
//                    }
//                }
//                return null;
//            }
//        }
//    }
//}
