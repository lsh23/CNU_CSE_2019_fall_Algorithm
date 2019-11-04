
def segmented_least_squares(n,points,c):
    M = [0]
    for j in range(1,n):
        for i in range(1,j):
            compute the least square error e_ij for the segment p_i, ... , p_j

    for j in range(1,n):
        M[j] =m min_(1<=i<=j) (e_ij + c + M[i-1])

    return M[n]


if __name__ == '__main__':
    with open("data08.txt","r",encoding='uft-8') as f:
        input_data = f.readline().split(",")
        n = int(input_data[0])
        points = []
        for i in range(1,n-2,2):
            points.append([input_data[i],[i+1]])
        c = int(input_data[-1]);

    segmented_least_squares(n,points,c)


