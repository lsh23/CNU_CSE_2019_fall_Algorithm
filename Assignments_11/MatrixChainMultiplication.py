def matrixChainMultipilcation():
    #....





if __name__ == '__main__':
    shapes = []
    with open("data11_matrix_chain.txt","r",encoding='utf-8') as f:
        for line in f:
            shape = line.strip().split(",")
            shape_i = int(shape[0])
            shape_j = int(shape[1])
            shapes.append([shape_i, shape_j])
    print(shapes)

    matrixChainMultipilcation(shapes)
