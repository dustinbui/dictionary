/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVLTree;

/**
 *
 * @author Anh Bui
 */
public class AVLTree {

    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    private Node leftRotate(Node p) {
        Node r = p.getRight();
        Node Y = r.getLeft();
        r.setLeft(p);
        p.setRight(Y);
        p.setHeight(1 + Math.max(getHeight(p.getLeft()), getHeight(p.getRight())));
        r.setHeight(1 + Math.max(getHeight(r.getLeft()), getHeight(r.getRight())));
        return r;                                                                       // Trả về nút gốc của cây
    }

    private Node rightRotate(Node p) {
        Node q = p.getLeft();
        Node Z = q.getRight();
        q.setRight(p);
        p.setLeft(Z);
        p.setHeight(1 + Math.max(getHeight(p.getLeft()), getHeight(p.getRight())));
        q.setHeight(1 + Math.max(getHeight(q.getLeft()), getHeight(q.getRight())));
        return q;                                                                       // Trả về nút gốc của cây
    }

    public Node insertNode(Node node, String e, String v) {
        if (node == null) {
            return new Node(e, v);
        }
        if (e.compareToIgnoreCase(node.getEn()) < 0) {
            node.setLeft(insertNode(node.getLeft(), e, v));
        } else if (e.compareToIgnoreCase(node.getEn()) > 0) {
            node.setRight(insertNode(node.getRight(), e, v));
        } else {
            return node;
        }

        node.setHeight(1 + Math.max(this.getHeight(node.getLeft()), this.getHeight(node.getRight())));
        int balanceNode = this.getHeight(node.getRight()) - this.getHeight(node.getLeft());
        //right - right
        if (balanceNode > 1 && e.compareToIgnoreCase(node.getRight().getEn()) > 0) {
            return leftRotate(node);
        }
        //left - left
        if (balanceNode < -1 && e.compareToIgnoreCase(node.getLeft().getEn()) < 0) {
            return rightRotate(node);
        }
        //right - left
        if (balanceNode > 1 && e.compareToIgnoreCase(node.getRight().getEn()) < 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
        //left - right
        if (balanceNode < -1 && e.compareToIgnoreCase(node.getLeft().getEn()) > 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
        return node;                                                                    
    }

    public Node search(Node root, String key) {
        if (root != null) {
            if (key.equals(root.getEn())) {
                return root;
            } else if (key.compareToIgnoreCase(root.getEn()) < 0) {
                return search(root.getLeft(), key);
            } else if (key.compareToIgnoreCase(root.getEn()) > 0) {
                return search(root.getRight(), key);
            } else {
                return null;
            }
        }
        return null;
    }
}
