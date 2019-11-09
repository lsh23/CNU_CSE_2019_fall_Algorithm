def sse_i_j(points):
    n = len(points)
    sum_xy = 0
    sum_x = 0
    sum_y = 0
    sum_xx = 0
    for point in points:
        x = point[0]
        y = point[1]
        sum_xy = sum_xy + x*y;
        sum_x = sum_x + x;
        sum_y = sum_y + y;
        sum_xx = sum_xx + x*x;
    a = (n*sum_xy-sum_x*sum_y)/(n*sum_xx-sum_x*sum_x)
    b = (sum_y-a*sum_x)/n
    sse = 0
    for point in points:
        x = point[0]
        y = point[1]
        sse = sse + (y-a*x-b)*(y-a*x-b)
    return sse,a,b

def segmented_least_squares(n,points,c):
    M = [0 for i in range(n)]
    e_ij = [[0]*n for i in range(n)]
    for j in range(n):
        for i in range(j):
            sse,a,b = sse_i_j(points[i:j+1])
            e_ij[i][j] = [sse,a,b]
    # print(e_ij)
    count = 0;
    slicePoint = [()] * (n)
    for j in range(n):
        M_j = 1000000000000000000;
        p= -1
        for i in range(j):
            if( M_j > (e_ij[i][j][0] + c + M[i-1]) ):
                M_j = (e_ij[i][j][0] + c + M[i-1])
                p=i
                #맨마지막에 바뀔때만 기억하면 되는상황
                #최소값인 경우의 ij
                # portion.append([e_ij[i][j],i,j])
            else:
                M_j = M_j
        if(p!=-1):
            slicePoint[j] = slicePoint[p] + (p,)
        sP = slicePoint[-1] + (n,)

        M[j]=M_j


        for index in range(len(sP)-1):
            start = sP[index]
            end = sP[index+1]-1
            sse = e_ij[start][end][0]
            a = e_ij[start][end][1]
            b = e_ij[start][end][2]
            print(str(start+1),"-",str(end+1)," : ",
            "y = ",a," * x " , b , "square error : " , sse)

    return M[n-1], sP

if __name__ == '__main__':
    with open("data08.txt","r",encoding='utf-8') as f:
        input_data = f.readline().split(",")
        n = int(input_data[0])
        points = []
        for i in range(1,2*n,2):
            points.append([float(input_data[i]),float(input_data[i+1])])
        c = int(input_data[-1]);
    e_ij = [[0]*n for i in range(n)]
    err, portion = segmented_least_squares(n,points,c)
    print(err)
